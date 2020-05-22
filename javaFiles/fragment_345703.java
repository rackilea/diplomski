public class SimpleBean {

  private String forename;
  private String surname;

  public String processData() {
    // TODO: real work
    System.out.println("forename=" + forename);
    System.out.println("surname=" + surname);
    return null; // optional navigation rule
  }

  public String getForename() {
    return forename;
  }

  public void setForename(String forename) {
    this.forename = forename;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

}