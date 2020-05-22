boolean result = mkdirs(dir);
if (!result) {
  String msg = "Directory " + dir.getAbsolutePath()
         + " creation was not successful for an unknown reason";
  throw new BuildException(msg, getLocation());
}