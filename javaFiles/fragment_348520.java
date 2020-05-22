public class Course implements Command {
  private final String tempCommand;
  private final ParentClass parent;

  public Course(final String tempCommand, final ParentClass parent) {
    this.tempCommand = tempCommand;
    this.parent = parent;
  }

  public void action() {
    parent.setCourse(tempCommand.split(parent.getDelimiter())[1]);
  }
};