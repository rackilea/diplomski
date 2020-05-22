public static void writeMatrix (int[][] matrix, int rowDim, int colDim, String pathStr)
    throws IOException
{
    Path path = new Path(pathStr);
    SequenceFile.Writer writer = SequenceFile.createWriter(fs, conf, path, 
        MatrixMultiply.IndexPair.class, IntWritable.class, 
        SequenceFile.CompressionType.NONE);
    MatrixMultiply.IndexPair indexPair = new MatrixMultiply.IndexPair();
    IntWritable el = new IntWritable();
    for (int i = 0; i < rowDim; i++) {
        for (int j = 0; j < colDim; j++) {
            int v = matrix[i][j];
            if (v != 0) { // !!! well, that would be why we aren't writing 0s
                indexPair.index1 = i;
                indexPair.index2 = j;
                el.set(v);
                writer.append(indexPair, el);
            }
        }
    }
    writer.close();
}