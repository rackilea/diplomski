String result = "";
for(int k : compressed){
  String entry;
  //affect entry here

  fos.write(entry);
  result += entry;
}

fos.close();       // close the file descriptor