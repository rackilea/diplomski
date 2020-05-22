Runtime re = Runtime.getRuntime();
BufferedReader output;          
try{ 
  cmd = re.exec("java -jar MyFile.jar" + argument); 
  output =  new BufferedReader(new InputStreamReader(cmd.getInputStream()));
} catch (IOException ioe){
  ioe.printStackTrace();
}
String resultOutput = output.readLine();