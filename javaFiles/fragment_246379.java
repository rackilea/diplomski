try (ServerSocket ss = new ServerSocket(SERVER_SOCKET_PORT);
        Socket s = ss.accept();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(s.getInputStream()))) {
    String line;
    while ((line = reader.readLine()) != null) {
        if (line.isEmpty() || line.equalsIgnoreCase("q")) {
            System.out.println("-- breaking the loop");
            break;
        }

        System.out.printf("**%s%n", line);
    }
} catch (Exception e) {
    e.printStackTrace();
}