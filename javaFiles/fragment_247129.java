public static void main( String[] args )
{
    Options options = new Options();
    options.addOption("v", "version", false, "Run with verbosity set to high")
           .addOption("h", "help", false, "Print usage")
           .addOption("r", "recurse", false, "Recurse subdirectories")
           .addOption("R", false, "Same as --recurse");

    CommandLine cmd = null;
    CommandLineParser parser = new PosixParser();
    try {
        cmd = parser.parse(options, args);
    } catch (ParseException e) {
        e.printStackTrace();
    }

    HelpFormatter formatter = new HelpFormatter();
    formatter.printHelp("cmdline-parser [OPTIONS] [FILES]", options);

}