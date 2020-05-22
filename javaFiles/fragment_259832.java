public class CommandPropertyEditor extends PropertyEditorSupport {
  public void setAsText(String text) {
    // create a command from the given text
    Command command = Command.createFromString(text);
    setValue(command);
  }
}