void copyFilesToDir(String srcDirPath, FileSystem fs, String destDirPath)
        throws IOException {
    File dir = new File(srcDirPath);
    for (File file : dir.listFiles()) {
        fs.copyFromLocalFile(new Path(file.getPath()),
                new Path(destDirPath, file.getName()));
    }
}