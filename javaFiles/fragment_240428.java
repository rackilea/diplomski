import java.io.FileOutputStream;
import java.io.IOException;

class FontChangeDemo {
    public static void main(String[] argv) throws IOException {
        byte[] reset = {0x1b, '@'};
        byte[] fontA = {0x1b, '!', 0x00};
        byte[] fontB = {0x1b, '!', 0x01};

        try(FileOutputStream outp = new FileOutputStream("/dev/usb/lp0")) {
            outp.write(reset);
            outp.write("Font A\n".getBytes());
            outp.write(fontB);
            outp.write("Font B\n".getBytes());
            outp.write(fontA);
            outp.write("Font A again\n".getBytes());
        }
    }
}