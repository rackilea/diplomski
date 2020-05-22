boolean result = mkdirs(dir);
if (!result) {
  if (dir.exists()) {
    log("A different process or task has already created "
         + "dir " + dir.getAbsolutePath(),
         Project.MSG_VERBOSE);
    return;
  }
  String msg = "Directory " + dir.getAbsolutePath()
         + " creation was not successful for an unknown reason";
  throw new BuildException(msg, getLocation());
}