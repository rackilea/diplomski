abstract class AbstractCommand() {
  abstract void execute();
}
class ConcreteCommand extends AbstractCommand {
  // execute implementation
}
// more command classes as needed; probably one per each of your method calls