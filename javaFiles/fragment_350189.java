private CLI commandLineInterface;

@Inject
public ApplicationRunner(CLI commandLineInterface){
     this.commandLineInterface = commandLineInterface;
}