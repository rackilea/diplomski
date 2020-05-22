private void createNewFile() {
 File newFile;
 File nf = null;
 String nt = "someName";
 if((newFile = new File(DirectoryPath.toString())).exists()) { //it must be a directorypath to create a new file in it.
  nf = new File(DirectoryPath, "withAverage" + nt + ".txt"); //create a new file
  nf.createNewFile();
 } averageFile = nf;
}

private void fileWriterInput() { 
 FileWriter fw = new FileWriter(averageFile); 
 try (BufferedWriter bw = new BufferedWriter(fw)) {
  bw.newLine();
  bw.append(inputString);
  bw.append("----------------------------------");
  bw.flush();
 }
}