import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;

public class MyWritable implements WritableComparable<MyWritable> {
    private IntWritable tgt;
    private IntWritable weight;

    public MyWritable() {
        set(new IntWritable(), new IntWritable());
    }

    public MyWritable(int tgt, int weight) {
        set(new IntWritable(tgt), new IntWritable(weight));
    }

    public MyWritable(IntWritable tgt, IntWritable weight) {
        set(tgt, weight);
    }

    public IntWritable getTgt() {
        return tgt;
    }

    public IntWritable getWeight() {
        return weight;
    }

    public void set(IntWritable tgt, IntWritable weight) {
        this.tgt = tgt;
        this.weight = weight;
    }

    @Override
    public int compareTo(MyWritable o) {
        int cmp = tgt.compareTo(o.tgt);
        if (cmp == 0) {
            return weight.compareTo(o.weight);
        }
        return cmp;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        tgt.write(dataOutput);
        weight.write(dataOutput);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        tgt.readFields(dataInput);
        weight.readFields(dataInput);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyWritable that = (MyWritable) o;
        return Objects.equals(tgt, that.tgt) &&
                Objects.equals(weight, that.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tgt, weight);
    }
}