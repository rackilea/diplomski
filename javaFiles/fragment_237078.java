System.out.println(socket + " " + "welcome\n");
try {
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    out.println(new Date().toString());
    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    String answer = input.readLine();
    System.out.println(answer);
    if ("hej".equals(answer)) {
        System.out.println("Sacrafice accepted");
    }
}
finally {
    socket.close();
}