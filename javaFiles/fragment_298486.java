public static void main(String[] args) throws Exception {
    ProcessBuilder pb = new ProcessBuilder("C:\\Users\\user\\Desktop\\file.exe");
    runProcess(pb)
}

private static void runProcess(ProcessBuilder pb) throws IOException {
    pb.redirectErrorStream(true);
    Process p = pb.start();
    BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
}