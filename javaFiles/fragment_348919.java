package com.hadoop.intellipaat;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class DnaWritable implements Writable {

    private Long bamWindow;
    private Long read;
    private Long refWindow;
    private Integer chr;
    private Double dist;

    public DnaWritable(Long bamWindow, Long read, Long refWindow, Integer chr, Double dist) {
        super();
        this.bamWindow = bamWindow;
        this.read = read;
        this.refWindow = refWindow;
        this.chr = chr;
        this.dist = dist;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeLong(bamWindow);
        out.writeLong(read);
        out.writeLong(refWindow);
        out.writeInt(chr);
        out.writeDouble(dist);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.bamWindow = in.readLong();
        this.read = in.readLong();
        this.refWindow = in.readLong();
        this.chr = in.readInt();
        this.dist = in.readDouble();
    }

}