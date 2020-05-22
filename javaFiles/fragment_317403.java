CommandLineParser parser = new PosixParser();
Options options = new Options();
options.addOption(new Option("h", "help", false, "display this message"));
options.addOption(new Option("c", "create", true, "Create a file"));
options.addOption(new Option("r", "read", truee, "Read a file"));
options.addOption(new Option("e", "edit", false, "Edit a file"));
options.addOption(new Option("d", "display", false, "Display a file"));
options.addOption(new Option("w", "write", false, "Write a file"));
options.addOption(new Option("p", "push", false, "Push a file"));

try {
    CommandLine commandLine = parser.parse(options, args);
    if (commandLine.hasOption("h")) {
        showHelp(options);
        System.exit(0);
    }
    // validate the commandline
    // obviously, these can be split up to give more helpful error messages
    if ((!(commandLine.hasOption("c") ^ (commandLine.hasOption("r") || commandLine.hasOption("e"))))
        || !(commandLine.hasOption("d") ^ commandLine.hasOption("w") ^ commandLine.hasOption("p"))) {
        throw new ParseException("Invalid combination");
    }
    if ((!commandLine.hasOption("c") && !commandLine.hasOption("r")) {
        throw new ParseException("Missing required arg");
    }

    // rest of the logic
} catch (ParseException pe) {
    throw new ParseException("Bad arguments\n" + pe.getMessage());
}