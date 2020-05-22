private static final String PROMPT = ">";

public static void main(String[] args) throws Exception {

    Session session = null;
    ChannelShell channel = null;

    try {

        JSch jsch = new JSch();
        session = jsch.getSession("root", "192.168.100.1", 22);
        session.setConfig("StrictHostKeyChecking", "no");
        session.setPassword("admin");
        session.connect();

        channel = (ChannelShell) session.openChannel("shell");

        PipedOutputStream reply = new PipedOutputStream();
        PipedInputStream input = new PipedInputStream(reply);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        channel.setInputStream(input, true);
        channel.setOutputStream(output, true);

        channel.connect();

        getPrompt(channel, output);
        writeCommand(reply, "reset");
        getPrompt(channel, output);

    } finally {

        if (channel != null) {
            channel.disconnect();
        }

        if (session != null) {
            session.disconnect();
        }
    }
}

private static void writeCommand(PipedOutputStream reply, String command) throws IOException {
    System.out.println("Command: " + command);
    reply.write(command.getBytes());
    reply.write("\n".getBytes());
}

private static void getPrompt(ChannelShell channel, ByteArrayOutputStream output)
        throws UnsupportedEncodingException, InterruptedException {

    while (!channel.isClosed()) {

        String response = new String(output.toByteArray(), "UTF-8");
        System.out.println(response);
        if (response.trim().endsWith(PROMPT)) {
            output.reset();
            return;
        }

        Thread.sleep(100);
    }
}