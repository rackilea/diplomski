public static void main(String[] args) throws IOException {

        // Define default host name
        String host = "228.5.6.7";
        // Define default port
        int port = 8804;
        if ((args.length != 1) || (!args[0].contains(":"))) {
            // throw new IllegalArgumentException("Syntax: MulticastChat <group>:<port>");
        } else {

            int idx = args[0].indexOf(":");
            host = args[0].substring(0, idx);
            port = Integer.parseInt(args[0].substring(idx + 1));
        }

        InetAddress group = InetAddress.getByName(host);
        MulticastChat chat = new MulticastChat(group, port);
        chat.start();
    }