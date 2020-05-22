public void close() {
    String dirPath = String.format("%s_dir/", date, timestamp);
    String newPath = String.format("%s_dir/%s_file", date, timestamp);
    try {
        fileSystem.mkdir(new Path(hdfs_path+dirPath));
        fileSystem.rename(new Path(hdfs_path+path), new Path(hdfs_path+newPath));
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}