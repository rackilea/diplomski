public class SliderIdBean {

  private long value = 0;
  private UIComponent mycontrol;

  public long getValue() {
    return value;
  }

  public void setValue(long value) {
    this.value = value;
  }

  public UIComponent getMycontrol() {
    return mycontrol;
  }

  public void setMycontrol(UIComponent mycontrol) {
    this.mycontrol = mycontrol;
  }

  public String getClientId() {
    FacesContext context = FacesContext
        .getCurrentInstance();
    return mycontrol.getClientId(context);
  }

  public String action() {
    System.out.println("Submitted value was: " + value);
    return null;
  }

}