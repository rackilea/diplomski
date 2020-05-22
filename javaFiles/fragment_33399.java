OutputStream os = openFile();
try {
  if (os.getChannel().tryLock() == null) return;
  ... write to the file ...
}
finally { os.close(); } // this automatically releases the lock