if(args.length > 0 && args[0].equals("ATTACH") {
        // Execute command-line program....
    } else {
        ArrayList<String> commands = new ArrayList<>();
        commands.add("cmd.exe");
        commands.add("/c");
        commands.add("start");
        commands.add("cd " + new File("").getAbsolutePath()); // cd to classpath
        commands.add("launcher.bat"); // The launcher that is in classpath

        ProcessBuilder pb = new ProcessBuilder(commands);

        Process p = pb.start();
    }