String command="C:\\my\\abc.bat";
Process process = null;
try {           
process = Runtime.getRuntime().exec(command); 
 OutputStream out=process.getOutputStream();
 out.write("mypass".getBytes());
 out.flush();