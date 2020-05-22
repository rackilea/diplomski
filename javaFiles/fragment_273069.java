String fileString;
//..
//read from the file
//..
//for windows
fileString = fileString.replaceAll("\\r\\n", "\n");
fileString = fileString.replaceAll("\\r", "\n");
//..
//write to file in binary mode.. something like:
DataOutputStream os = new DataOutputStream(new FileOutputStream("fname.txt"));
os.write(fileString.getBytes());
//..
//send file
//..