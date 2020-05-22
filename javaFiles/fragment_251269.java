PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); 
File file = new File(path);
if( !file.exist()){
  out.write("HTTP 404") // the file does not exists  
}
FileReader fr = new FileReader(file);
BufferedReader bfr = new BufferedReader(fr);
String line;
while((line = bfr.readLine()) != null){
  out.write(line);
}

bfr.close();
br.close();
out.close();