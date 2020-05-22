public static void main(String[] args) throws ParseException{
    // create Options object
    Options options = new Options();
    CommandLineParser parser = new DefaultParser();

    // add t option
    options.addOption("t", false, "display current time");

    CommandLine cmd = parser.parse( options, args);

    if(cmd.hasOption("t")) {
        // print the date and time
    }else {
        // print the date
    }

}