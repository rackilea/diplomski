ProcessBuilder pb = new ProcessBuilder("cmd /C tsc hello.ts");

//merge error output with the standard output
pb.redirectErrorStream(true);

Process p = pb.start();
try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream(), Charset.forName("UTF-8")))) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
}