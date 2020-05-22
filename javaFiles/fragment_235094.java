/**
 * CRC16. An implementation of {@link java.util.zip.Checksum} for 16-bit cyclic redundancy checks.
 *
 */

import java.util.zip.Checksum;

/**
 * CRC16. An implementation of {@link java.util.zip.Checksum} for 16-bit cyclic redundancy checks.
 * 
 * @author Esmond Pitt.
 */
public class CRC16 implements Checksum
{
    public enum Algorithm
    {
        CRC_CCIT(POLYNOMIAL_CCITT, INIT_CCITT),
        XMODEM(POLYNOMIAL_XMODEM, (short)0),
        ARC(POLYNOMIAL_ARC, (short)0),
        IBM(POLYNOMIAL_IBM, (short)0),
        ANSI(POLYNOMIAL_IBM, (short)0);

        Algorithm(int polynomial, short initialValue)
        {
            this.polynomial = polynomial;
            this.initialValue = initialValue;
        }

        int polynomial;
        short initialValue;
    };

    /**
     * CRC-CCITT polynomial, used by X.25, V.41, Bluetooth, PPP, IrDA, BACnet; known as CRC-CCITT
     */
    public static final int POLYNOMIAL_CCITT = 0x1021;
    public static final short INIT_CCITT = (short)0xffff;
    /**
     * CRC-16 polynomial, used by XMODEM, USB, many others; also known as CRC-16
     */
    public static final int POLYNOMIAL_IBM = 0xa001;
    public static final int POLYNOMIAL_XMODEM   = 0x8408;
    public static final int POLYNOMIAL_ARC = 0x8005;

//  private final int   polynomial;
    private final short init;
    private final short[]   crcTable = new short[256];
    private short   value;

    /**
     * Construct a CRC16-CCIT, with polynomial=0x1021 and initial value=0xffff.
     */
    public CRC16()
    {
        this(Algorithm.CRC_CCIT);
    }

    /**
     *  COnstruct a polynomial specifying the algorithm.
     *
     * @param algorithm Algorithm
     */
    public CRC16(Algorithm algorithm)
    {
        this(algorithm.polynomial, algorithm.initialValue);
    }

    /**
     * Construct a CRC16 specifying the polynomial and initial value.
     * @param polynomial Polynomial, typically one of the POLYNOMIAL_* constants.
     * @param init Initial value, typically either 0xffff or zero.
     */
    public CRC16(int polynomial, short init)
    {
//      this.polynomial = polynomial;
        this.value = this.init = init;
        for (int dividend = 0; dividend < 256; dividend++)
        {
            int remainder = dividend << 8;
            for (int bit = 8; bit > 0; --bit)
                if ((remainder & 0x8000) != 0)
                    remainder = (remainder << 1) ^ polynomial;
                else
                    remainder <<= 1;
            crcTable[dividend] = (short)remainder;
        }
    }

    @Override
    public void update(byte[] buffer, int offset, int len)
    {
        for (int i = 0; i < len; i++)
        {
            int data = buffer[offset+i] ^ (value >>> 8);
            value = (short)(crcTable[data & 0xff] ^ (value << 8));
        }
    }

    /**
     * Updates the current checksum with the specified array of bytes.
     * Equivalent to calling <code>update(buffer, 0, buffer.length)</code>.
     * @param buffer the byte array to update the checksum with
     */
    public void update(byte[] buffer)
    {
        update(buffer, 0, buffer.length);
    }

    @Override
    public void update(int b)
    {
        update(new byte[]{(byte)b}, 0, 1);
    }

    @Override
    public long getValue()
    {
        return value;
    }

    @Override
    public void reset()
    {
        value = init;
    }

    /** Tester */
    public static void  main(String[] args)
    {
        byte[]  data = new byte[]{0x31,0x32,0x33,0x34,0x35,0x36,0x37,0x38,0x39};
        CRC16   crc16 = new CRC16();
        crc16.update(data,0,data.length);
        System.out.println("CCITT:\t\t\tinit=0xffff poly=0x1021 CRC16(\"123456789\")=0x29b1");
        System.out.println("Calculated:\t\tinit=0x"+Integer.toHexString(INIT_CCITT & 0xffff)+" poly=0x"+Integer.toHexString(POLYNOMIAL_CCITT)+" CRC16(\"123456789\")=0x"+Long.toHexString(crc16.getValue()));
        System.out.println("Test successful:\t"+(crc16.getValue() == 0x29b1));

        String  s = "hello";

        crc16 = new CRC16(POLYNOMIAL_IBM, INIT_CCITT);
        data = new byte[]{0x02, 0x14, 0x14, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
        crc16.update(data, 0, data.length);
        System.out.println("CRC16=0x"+Integer.toHexString((int)crc16.getValue()  & 0xffff));
    }
}