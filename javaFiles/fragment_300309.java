public class Test {
short[] it = new short[4];
byte[] by = new byte[4];

public static void main(String[] args) {
    Test Convert = new Test();
    Convert.start();
}

public void start() {
    it = new short[] { 192, 168, 1, 2 };

    ByteBuffer bytBuff = ByteBuffer.allocateDirect(2000);
    for (int i = 0; i < it.length; i++) {

        bytBuff.putShort(it[i]);
        by[i] = bytBuff.get(i);
        System.out.print("I get byte  " + by[i] + "\n\n");
        System.out.print("I get short  " + it[i] + "\n\n");
        System.out.print("I get buffer " + bytBuff.get(i) + "\n\n");
    }
}
}