/** Returns a qualified path object. */
public Path makeQualified(FileSystem fs) {
  Path path = this;
  if (!isAbsolute()) {
    path = new Path(fs.getWorkingDirectory(), this);
  }