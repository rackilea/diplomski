public class ToDoItem {

  private  String description;
  private  Date dueDate;
  private  Priority priority;

  private static DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

  public ToDoItem() {
  }

  public ToDoItem(String desc) {
    description = desc;
    dueDate = null;
    priority = Priority.HIGH;
  }
  public ToDoItem(String desccription, String d) throws ParseException{
    this.description = description;
    dueDate = df.parse(d);
  }
  public ToDoItem(String description, String p, String d) throws ParseException{
    this.description = description;
    this.priority = Priority.valueOf(p.toUpperCase());
    dueDate = df.parse(d);
  }
  public String toString() {
    return description + " -"+priority+"- " + df.format(dueDate);
  }

  public void setDueDate(String s) {
    try {
      dueDate = df.parse(s);
    } catch(Exception ex) {
      System.out.println(ex);
    }
  }
  public String getDescription() {
    return description;
  }
  public String getDueDate() {
    return df.format(dueDate);
  }
}