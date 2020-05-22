public class Packer {

    private byte data;

    public byte getData () {
        byte result = this.data;
        this.data = 0;
        return result;
    }

    //only last bit counts (thus bit is 0 or 1)
    public void addBit (byte bit) {
        this.data <<= 0x01;
        this.data |= bit;
    }

}