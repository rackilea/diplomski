val myCommand = MyCommand();
val commandLine = CommandLine(myCommand);

// tell parser to be lenient 
commandLine.getCommandSpec().parser().collectErrors(true);

// parse user input, query result for errors 
val parseResult = commandLine.parseArgs(args); 
val parseErrors: List<Exception> = parseResult.errors();

// ignoring the errors for now...
myCommand.execute();
val output = myCommand.getOutput();
val appErrors: List<String> = myCommand.getErrors();