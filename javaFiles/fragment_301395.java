Process process = new ProcessBuilder("C:\\PathToExe\\MyExe.exe","param1","param2").start();
InputStream is = process.getInputStream();
InputStreamReader isr = new InputStreamReader(is);
BufferedReader br = new BufferedReader(isr);
String line;

System.out.printf("Output of running %s is:", Arrays.toString(args));

while ((line = br.readLine()) != null) {
  System.out.println(line);
}