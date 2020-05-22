connection.setDoInput(true);
InputStreamReader reader =  new InputStreamReader(connection.getInputStream());
char[] cbuf = new char[100];
reader.read(cbuf); 
// there are 3 read method you can choose as per your convenience 
//and put a check for end of line in while loop for reading whole content. 
reader.close();