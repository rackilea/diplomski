package java.nio; //has to be in java.nio pkg, _get() and _put and pkg-private

public class SerializableByteBuffer extends ByteBuffer implements Externalizable {
    private ByteBuffer theActualBuffer;

    public SerializableByteBuffer(ByteBuffer theActualBuffer) {
        super(0, 0, 1, 1);
        this.theActualBuffer = theActualBuffer;
    }

    // these 2 are package private. this was obviously not designed to be extended

    @Override
    byte _get(int i) {
        return theActualBuffer._get(i);
    }

    @Override
    void _put(int i, byte b) {
        theActualBuffer._put(i, b);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        //write length + type of underlying buffer (enum?) + contents
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        //read length and type of buffer, instantiate buffer of correct type, read contents into buffer
    }

    //delegate all methods. this is going to be a lot of work as some return buffer copies
}