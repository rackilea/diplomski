public class Animal {

  private boolean isPet = false;
  private String nickname = "";

  public Animal() {
    /*...*/
  }

  public makeStray() {
    isPet = false;
    nickname = "";
  }

  public makePet(String nickname) {
    isPet = true;
    this.nickname = nickname;
  }

  public boolean isPet() {
    return isPet;
  }

  public void makeNoise() {
    /* Override in child classes */
  }

}