class Element {

  /** Attribute used to sort the elements */
  private String value;

  /** Attribute used to remember the original position of this element in the list */
  private int position;

  public Element(String value, int position) {
    this.value = value;
    this.position = position;
  }

  public String getValue() {
    return value;
  }

  public int getPosition() {
    return position;
  }

  /** Insert equals and hashCode! */
}