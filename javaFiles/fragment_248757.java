public static void main(String[] args) throws IOException {
  ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "c: && cd \"C:\\Users\\erdemk\\Desktop\\directory\" && dir");
  builder.redirectErrorStream(true);
  Process p = builder.start();
    BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
    String line;
    while (true) {
        line = r.readLine();
        if (line == null) { break; }
        System.out.println(line);
    }
}