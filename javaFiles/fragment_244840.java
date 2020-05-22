try {
   rename(file1, tmpName);
   rename(file2, file1);
   rename(tmpFile, file2);
   return true;
}
catch (IOException e) {
   e.printStackTrace();
   return false;
}