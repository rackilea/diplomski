FileSystem fs = null;
SequenceFile.Writer writer;
Configuration conf = new Configuration();

List<NamedVector> vectors = <here's your List of vectors obtained from CSVVectorIterator>;

// Write the data to SequenceFile
try {
    fs = FileSystem.get(conf);

    Path path = new Path(<your path> + <your filename>);
    writer = new SequenceFile.Writer(fs, conf, path, Text.class, VectorWritable.class);

    VectorWritable vec = new VectorWritable();
    for (NamedVector vector : dataVector) {

        vec.set(vector);
        writer.append(new Text(vector.getName()), vec);

    }
    writer.close();

} catch (Exception e) {
    System.out.println("ERROR: "+e);
}