FileSystem fs = FileSystem.get(URI.create(arg0[0]), conf);
Path path = new Path(arg0[0] + arg0[1]); // arg0[1] NYSE_201[2-3]
//arg0[0] is base path
//ar0[1] uses regular expression

FileStatus[] status = fs.globStatus(path);
Path[] paths = FileUtil.stat2Paths(status);
for (Path p : paths) {
    // <loops all the source paths>
    // <need to implement logic to rename the paths using fs.rename>
}