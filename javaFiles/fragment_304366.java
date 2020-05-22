ConsoleParser<Cmd<Object>> parser = cli("add",new ParseAdd()) 
   .or(...)
   .or("quit", new ParseQuit();

Scanner input = new Scanner(System.in);
String parserArgs = input.nextLine(); 

while (true) 
{
    try {
       parser.parse(parserArgs).execute();
    } catch (CliParseException e) {
       // handle it somehow
    }
    parserArgs = input.nextLine();   
}