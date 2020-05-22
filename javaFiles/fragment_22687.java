public interface DvdReader {
        default public void read() {
                System.out.println("DvdReader.read()");
        }
}

public interface CdReader {
        default public void read() {
                System.out.println("CdReader.read()");
        }
}

public class ComboReader implements CdReader, DvdReader {
        public void read() {
                CdReader.super.read();
                DvdReader.super.read();
        }

        public static void main(String[] args) {
                new ComboReader().read();
        }
}