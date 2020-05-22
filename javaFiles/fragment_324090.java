Process p = Runtime.getRuntime().exec(new String[] {"ipconfig", g});
InputStream s = p.getInputStream();

BufferedReader in = new BufferedReader(new InputStreamReader(s));
String temp;

while ((temp = in.readLine()) != null) {
    System.out.println(temp);
}