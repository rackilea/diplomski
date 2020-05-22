class Animal<Relative extends Animal<?>> {
  private List<? extends Relative> relatives;

  public List<? extends Relative> getRelatives() {
    return relatives;
  }

  public void setRelatives(List<? extends Relative> relatives) {
    this.relatives = relatives;
  }
}

class Dog extends Animal<Dog> {}