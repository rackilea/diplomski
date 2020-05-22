public static void main(String[] args) throws Exception {
    FSDataOutputStream fout = null;
    try {
        Path path = new Path("hdfs://NaeNode:9000/input/SG.csv");
        String data = "data";
        FileSystem fileSystem = FileSystem.get(new Configuration());
        if (!fileSystem.exists(path)) {
            fout = fs.create(path); 
        } else {
            fout = fs.append(path)
        }
        BufferedWriter bufferedWriter = new BufferedWriter(
            new OutputStreamWriter(fout)
        );
        bufferedWriter.write(data);
        bufferedWriter.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}