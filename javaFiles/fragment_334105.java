public class Driver {
    private static final int dataSize = (int) (Runtime.getRuntime().maxMemory() * 0.6);

    public static void main(String[] args) throws InterruptedException {
        {
            System.out.println(dataSize);
            byte[] data = new byte[dataSize];

        }
        byte i = 1;
        System.out.println(dataSize);
        byte[] data2 = new byte[dataSize];
    }

}