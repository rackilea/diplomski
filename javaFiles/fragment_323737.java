public class LengthCounterOutputStream extends OutputStream{

    private int byteCounter = 0;

    @Override
    public void write(int b){
        byteCounter++;
    }

    @Override
    public void write(@NotNull byte[] b){
        this.write(b, 0, b.length);
    }

    @Override
    public void write(@NotNull byte[] b, int off, int len){
        byteCounter += len;
    }

    public int getByteCounter(){
        return byteCounter;
    }
}