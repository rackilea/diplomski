try {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    String command = " ";
    while (command != null) {
        System.out.print(">>> ");
        command = r.readLine();
        processCommand(command);
    }
 } catch (IOException e) {
     System.out.println("Something went wrong.");
 }