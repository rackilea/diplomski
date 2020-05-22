public abstract class Character extends GameObject {
  Status status;
  ArrayList<Status> immunities = new ArrayList<>();
  //fields, methods, etc.

  public void addImmunity(Status immunity) {
    immunities.add(immunity);
  }

  // return false if the status couldn't be set in case you want to do something
  // like show an "Immune!" message or something like that
  public boolean setStatus(Status status) {
    if (immunities.contains(status)) {
      return false;
    }
    this.status = status;
    return true;
  }
}

class FireGolem extends Monster {
  public FireGolem() {
    addImmunity(Status.BURNING);
  }
}