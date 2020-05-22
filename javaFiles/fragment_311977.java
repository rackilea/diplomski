import java.nio.ByteBuffer;
public byte[] getBOMMessage(int xmlLenght) {
    byte[] arr = new byte[7];
    ByteBuffer buf = ByteBuffer.wrap(arr);
    buf.putInt(xmlLenght+3);
    arr[4]=(byte)0xef;
    arr[5]=(byte)0xbb;
    arr[6]=(byte)0xbf;
    return arr;
}