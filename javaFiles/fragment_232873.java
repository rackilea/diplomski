Process p = Runtime.exec("myExeOrShellScript");
BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
String line;
while ((line = r.readLine())!=null) {
  // got the output in 'line' do something with it
}
r.close();