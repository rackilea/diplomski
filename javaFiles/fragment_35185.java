public class MinMaxAvgWritable implements Writable {

    private int min, max;
    private double avg;

    private DecimalFormat df = new DecimalFormat("#.00");

    @Override
    public String toString() {
        return "MinMaxAvgWritable{" +
                "min=" + min +
                ", max=" + max +
                ", avg=" + df.format(avg) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MinMaxAvgWritable that = (MinMaxAvgWritable) o;
        return min == that.min &&
                max == that.max &&
                avg == that.avg;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max, avg);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(min);
        dataOutput.writeInt(max);
        dataOutput.writeDouble(avg);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.min = dataInput.readInt();
        this.max = dataInput.readInt();
        this.avg = dataInput.readDouble();
    }

    public void set(int min, int max, double avg) {
        this.min = min;
        this.max = max;
        this.avg = avg;
    }

    public void set(Iterable<IntWritable> values) {
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;

        int sum = 0;
        int count = 0;
        for (IntWritable iw : values) {
            int i = iw.get();
            if (i < this.min) this.min = i;
            if (i > max) this.max = i;
            sum += i;
            count++;
        }

        this.avg = count < 1 ? sum : (sum / (1.0*count));
    }
}