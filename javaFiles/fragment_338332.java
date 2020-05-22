...
Option opt1 = OptionBuilder.hasArgs(1).withArgName("output directory")
    .withDescription("This is the output directory").isRequired(true)
    .withLongOpt("output").create("O");

Option opt2 = OptionBuilder.hasArgs(1).withArgName("file name")
    .withDescription("This is the file name").isRequired(true)
    .withLongOpt("name").create("N")

Options o = new Options();
o.addOption(opt1);
o.addOption(opt2);
CommandLineParser parser = new BasicParser();

try {
  CommandLine line = parser.parse(o, args); // args are the arguments passed to the  the application via the main method
  if (line.hasOption("output") {
     //do something
  } else if(line.hasOption("name") {
     // do something else
  }
} catch(Exception e) {
  e.printStackTrace();
}
...