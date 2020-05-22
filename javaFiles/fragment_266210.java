public class SavePersonCommandHandler implements ICommandHandler<SavePersonCommand> {

    @Inject
    IPersonRepository personRepository;

    @Override
    public void handle(SavePersonCommand command) {
        Person person = command.getPerson();
        personRepository.save(person); 
    }
}