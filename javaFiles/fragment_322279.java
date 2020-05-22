for (int i = maxBackupIndex - 1; i >= 1 && renameSucceeded; i--) {
file = new File(fileName + "." + i);
if (file.exists()) {
  target = new File(fileName + '.' + (i + 1));
  LogLog.debug("Renaming file " + file + " to " + target);
  renameSucceeded = file.renameTo(target);
}
  }