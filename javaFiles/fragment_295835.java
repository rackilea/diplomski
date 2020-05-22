public class MyModel extends Observable {
  private String btnname;
  public String getBtnname() {
    return btnname;
  }
  public void setBtnname(String btnname) {
    this.btnname = btnname;
    pingObservers()
  }
  private void pingObservers() {
   setChanged();
   notifyObservers();
  }
}