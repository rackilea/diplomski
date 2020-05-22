Process p=Runtime.getRuntime().exec(new String[]{"./hello"});
p.waitFor();
BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream()));
String line=reader.readLine();
while(line!=null) {
    System.out.println(line);
    line=reader.readLine();
}