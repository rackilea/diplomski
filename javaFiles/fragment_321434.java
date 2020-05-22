public class BitList {

    private int nBits = 0;
    private long[] data = new long[2];

    //0 or 1
    public void add (byte data) {
        if(nBits >= 64*data.length) {
            long[] newdata = new long[2*data.length];
            for(int i = 0; i < data.length; i++) {
                newdata[i] = data[i];
            }
            this.data = newdata;
        }
        data[nBits/64] |= data<<(nBits&0x3f);
        nBits++;
    }

    public byte get (int index) {
        long val = data[index/64]>>(index&0x3f);
        return (byte) (val&0x01);
    }

    //and so on.

}