OutputStream outToClient = socke.getOutputStream();
// The file name needs to come from the client which will be put in here below
File myfile = new File("D:\\ "+file_name);
byte[] mybytearray = new byte[(int) myfile.length()];
BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myfile));
bis.skip(filePosition) //Advance the stream to the desired location in the file
bis.read(mybytearray, 0, mybytearray.length);
outToClient.write(mybytearray, 0, mybytearray.length);
System.out.println("Arrays on server:"+Arrays.toString(mybytearray));
outToClient.flush();
bis.close();