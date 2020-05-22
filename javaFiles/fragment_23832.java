import java.io.*;
import java.nio.charset.Charset;

public class BinHexDec {

    private Charset charset;

    private String filename;

    private int dbegin, dend, rbegin, rend;

    public BinHexDec(String... args) throws IOException {
        InputStream in = System.in;
        OutputStream out = System.out;
        charset = Charset.defaultCharset();
        if (args.length >= 1)
            in = new FileInputStream(args[0]);
        if (args.length >= 2)
            out = new FileOutputStream(args[1]);
        if (args.length >= 3)
            charset = Charset.forName(args[2]);
        Reader reader = new InputStreamReader(in, charset);
        byte[] data;
        data = unbase(reader);
        reader.close();
        if (data.length < 27)
            throw new IOException("Too little data");
        data = unrle(data);
        parse(data);
        out.write(data, dbegin, dend - dbegin);
    }

    private byte[] unbase(Reader in) throws IOException {
        String digits = "!\"#$%&'()*+,-012345689@ABCDEFGHIJKLMNPQRSTUVXYZ" +
            "[`abcdefhijklmpqr";
        assert digits.length() == (1 << 6);
        int[] value = new int[128];
        for (int i = 0; i < value.length; ++i)
            value[i] = -1;
        for (int i = 0; i < digits.length(); ++i)
            value[digits.charAt(i)] = i;

        int state = 0;
        int accum = 0;
        int alen = 0;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while (true) {
            int chr = in.read();
            if (chr == -1)
                throw new EOFException();
            switch (state) {
            case 0:
                switch (chr) {
                case '\n':
                case '\r':
                case '\t':
                case ' ':
                    state = 1;
                    break;
                }
                break;
            case 1:
                switch (chr) {
                case '\n':
                case '\r':
                case '\t':
                case ' ':
                    break;
                case ':':
                    state = 2;
                    break;
                default:
                    state = 0;
                }
                break;
            case 2:
                int v = -1, c = chr & 0x7f;
                if (c == chr) {
                    v = value[c];
                    if (v != -1) {
                        accum = (accum << 6) | v;
                        alen += 6;
                        if (alen > 8) {
                            alen -= 8;
                            baos.write((byte)(accum >>> alen));
                        }
                        break;
                    }
                }
                if (chr == ':') {
                    return baos.toByteArray();
                }
                break;
            }
        }
    }

    private static final byte RLE_MARK = (byte)0x90;

    private byte[] unrle(byte[] in) throws IOException {
        int len = in.length;
        if (in[0] == 0x90)
            throw new IOException("Incomplete RLE at beginning");
        for (int i = 0; i < in.length; ++i) {
            if (in[i] == RLE_MARK) {
                ++i;
                if (i == in.length)
                    throw new IOException("Incomplete RLE at end");
                int cnt = in[i] & 0xff;
                if (cnt == 0)
                    len -= 1;
                else
                    len += cnt - 3;
            }
        }
        byte[] out = new byte[len];
        for (int i = 0, o = 0; i < in.length; ++i) {
            if (in[i] == RLE_MARK) {
                ++i;
                int cnt = in[i] & 0xff;
                if (cnt == 0)
                    out[o++] = RLE_MARK;
                else {
                    byte b = out[o - 1];
                    for (int c = 1; c < cnt; ++c)
                        out[o++] = b;
                }
            }
            else {
                out[o++] = in[i];
            }
        }
        return out;
    }

    private int get4(byte[] data, int offset) {
        return ((data[offset    ] & 0xff) << 24)
            |  ((data[offset + 1] & 0xff) << 16)
            |  ((data[offset + 2] & 0xff) <<  8)
            |  ((data[offset + 3] & 0xff)      );
    }

    private int get2(byte[] data, int offset) {
        return ((data[offset] & 0xff) << 8)
            |  ((data[offset + 1] & 0xff));
    }

    private void crcCheck(byte[] data, int begin, int end) throws IOException {
        int crc = 0;
        for (int i = begin; i < end; ++i) {
            crc = ((crc  << 4)&0xffff) ^ (crc >> 12)*0x1021;
            crc = ((crc  << 4)&0xffff) ^ (crc >> 12)*0x1021;
            crc = crc ^ (data[i] & 0xff);
        }
        crc = ((crc  << 4)&0xffff) ^ (crc >> 12)*0x1021;
        crc = ((crc  << 4)&0xffff) ^ (crc >> 12)*0x1021;
        crc = ((crc  << 4)&0xffff) ^ (crc >> 12)*0x1021;
        crc = ((crc  << 4)&0xffff) ^ (crc >> 12)*0x1021;
        int expected = get2(data, end);
        if (expected != crc)
            throw new IOException("CRC mismatch");
    }

    private void parse(byte[] in) throws IOException {
        int namelen = in[0] & 0xff;
        int headlen = namelen + 20;
        int dlen = get4(in, headlen - 8);
        int rlen = get4(in, headlen - 4);
        if (dlen < 0 || rlen < 0)
            throw new IOException("Unsigned data lenhgths not supported");
        dbegin = headlen + 2;
        dend = dbegin + dlen;
        rbegin = dend + 2;
        rend = rbegin + rlen;
        if (in.length != rend + 2 &&
            (in.length != rend + 3 || in[rend + 2] != 0))
            throw new IOException("Incorrect data size:" +
                                  " expected " + (rend + 2) +
                                  " but got " + in.length + " bytes");
        crcCheck(in, 0, headlen);
        crcCheck(in, dbegin, dend);
        crcCheck(in, rbegin, rend);
        filename = new String(in, 1, namelen, charset);
        System.err.println(filename);
    }

    public static void main(String[] args) throws IOException {
        new BinHexDec(args);
    }

}