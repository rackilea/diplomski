abstract class Insect {
  abstract void eat();
}

class Spider extends Insect{
  @Override
  public void eat(){
    //eat dung
  }
}

class Worm extends Insect {
  @Override
  public void eat(){
    //eat soil
  }
}