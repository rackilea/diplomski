String line;
try {
    Process proc = Runtime.getRuntime().exec("wmic.exe");
    BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));
    OutputStreamWriter oStream = new OutputStreamWriter(proc.getOutputStream());
    oStream .write("process where name='explorer.exe'");
    oStream .flush();
    oStream .close();
    while ((line = input.readLine()) != null) {
        System.out.println(line);
    }
    input.close();
} catch (IOException ioe) {
    ioe.printStackTrace();
}