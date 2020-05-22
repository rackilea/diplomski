public class DoubleArrayWritable implements Writable {
    private double[] data;

    public DoubleArrayWritable() {

    }

    public DoubleArrayWritable(double[] data) {
        this.data = data;
    }

    public double[] getData() {
        return data;
    }

    public void setData(double[] data) {
        this.data = data;
    }

    public void write(DataOutput out) throws IOException {
        int length = 0;
        if(data != null) {
            length = data.length;
        }

        out.writeInt(length);

        for(int i = 0; i < length; i++) {
            out.writeDouble(data[i]);
        }
    }

    public void readFields(DataInput in) throws IOException {
        int length = in.readInt();

        data = new double[length];

        for(int i = 0; i < length; i++) {
            data[i] = in.readDouble();
        }
    }
}