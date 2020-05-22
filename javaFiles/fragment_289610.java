public static void main(String[] args) {
    String command1 = "echo hello";
    String command2 = "echo hi";
    System.out.println(executerCommand(command1));
    System.out.println(executerCommand(command2));
}

public static String executCommand(String command) {
    String line;
    String resultat = "";
    try {
        ProcessBuilder builder;

        builder = new ProcessBuilder("cmd.exe", "/c", command);

        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while (true) {
            line = r.readLine();
            if (line == null) {
                break;
            }
            resultat += line + "\n";
        }
    } catch (IOException e) {
        System.out.println("Exception = " + e.getMessage());
    }
    return resultat;
}