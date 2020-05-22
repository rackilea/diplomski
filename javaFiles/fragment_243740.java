public class DatapathObject {
  private Object parent;
  private Field field;

  public DatapathObject(Object parent, Field field) {
    this.parent = parent;
    this.field = field;
  }

  public Object getParent() {
    return parent;
  }

  public Field getField() {
    return field;
  } 
}