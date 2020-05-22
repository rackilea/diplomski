@Override
public void readFields(DataInput in) throws IOException {       
    VID=in.readLong();
    long vector_size=in.readLong();
    for(int i=0;i<count;i++)
        Adjacent.addElement(in.readLong());
    }
}

@Override
public void write(DataOutput out) throws IOException {      
    out.writeLong(VID); 
    out.writeLong(Adjacent_nodes.size());
    for(int i=0;i<count;i++)
        out.writeLong(Adjacent.get(i));
}