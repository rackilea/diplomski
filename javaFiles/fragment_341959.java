Process proc = Runtime.getRuntime().exec(cmd);
BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
proc.waitFor();

while (in.ready()) {
    System.out.println(in.readLine());
}