@Parameters(commandDescription = "foo-command short description")
public class FooCommand implements Command {

    @Parameter(names = {"-?", "--help"}, description = "display this help", 
        help = true)
    private boolean helpRequested = false;

    @Parameter(description = "This command is used as base foo")
    public List<String> commandOptions;

    // your command code goes below
}