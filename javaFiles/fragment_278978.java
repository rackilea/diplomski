class Animal {
  protected int age;

  protected void birthday() {
   age++;
  }
}

class Cow extends Animal {

  public Cow() {
     age = 5;
  }

  public void act() {
    super.act();
    //make the cow move
    birthday();

    if(birthACalf()) {
       Calf calf = new Calf();
       calf.putSelfInGrid(....);
    }
  }
}

class Calf extends Animal {

  public void act() {
    super.act();
    birthday();

    if(age >= 5) {
      removeSelfFromGrid();
      Cow cow = new Cow();
      cow.putSelfInGrid(....);
    }
  }
}