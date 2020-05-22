String path = null;
File[] dirs = getContext().getExternalFilesDirs(null);
if (dirs!=null && Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
    path = dirs[dirs.length-1].getAbsolutePath();
    path = path.substring(0, path.indexOf("Android"));
}
 return path;