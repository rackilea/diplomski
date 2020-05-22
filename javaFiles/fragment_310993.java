String msg = "";
while (!msg.toLowerCase().equals("/exit")) {
    msg = keyboard.nextLine();

    if (msg.toLowerCase().equals("/exit")) {
        // stop inputThread.
        // make sure inputThread is stopped.
    }

    if (!msg.trim().equals("")) {
        pw.println(msg);
        pw.flush();
    }
}