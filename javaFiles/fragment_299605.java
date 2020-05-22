void processCommand(String line) {
    if (line.equals(...)) {
        // Process each command like this
    }
    else if (line.equals("quit")) {
        socket.close();
    }
    else {
        System.err.println("Unrecognized command: " + line);
    }
}