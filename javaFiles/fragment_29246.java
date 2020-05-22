int port = 80;
Process p = Runtime.getRuntime().exec("lsof -i :" + port + " | awk '{print $1}'");

BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
while ((s = reader.readLine()) != null) {
    System.out.println(s);
}