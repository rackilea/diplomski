Process p = pb.start();
BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
String line = null;
while ((line = br.readLine()) != null) {
   System.out.println(line);
}

p.waitFor();

br.close();