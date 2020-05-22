File file = new File(this.getExternalFilesDir(null), "testfile.txt");
FileOutputStream fileOutput = new FileOutputStream(file);
OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutput);
outputStreamWriter.write("lalala");
outputStreamWriter.flush();
fileOutput.getFD().sync();
outputStreamWriter.close();