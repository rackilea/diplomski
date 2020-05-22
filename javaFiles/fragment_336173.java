String line;
Process p = Runtime.getRuntime().exec("c:\\ping.bat");
BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
while ((line = in.readLine()) != null) {
    System.out.println(line);
    textarea.append(line);
}
in.close();