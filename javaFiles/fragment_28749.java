@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "childName" })
class Child implements Serializable {
  private static final long serialVersionUID = -6058827989172575778L;
  private String childName;
  @XmlTransient
  @JsonIgnore
  private Parent parent;
  public String getChildName() {
    return childName;
  }
  public void setChildName(String childName) {
    this.childName = childName;
  }
  public Parent getParent() {
    return parent;
  }
  public void setParent(Parent parent) {
    this.parent = parent;
  }
}