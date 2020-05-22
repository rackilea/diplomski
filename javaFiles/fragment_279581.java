class Monster {
  public abstract boolean likesElves();
}

class Orc extends Monster {
  public boolean likesElves() {
    return false;
  }
}

class Elf extends Monster {
  public boolean likesElves() {
    return true;
  }
}