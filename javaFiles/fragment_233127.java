class Wizard {
  final int DEFAULT_AGE_DECREASE = 2;

  ...

  void agingSpell(Person p) {
    this.agePerson(p, DEFAULT_AGE_DECREASE);
  }

  void agingSpell(Person p, int years) {
    // let's keep a person's age a protected field
    p.setAge(p.age - years);

    // and you'll probably need logic for age hitting/dropping below zero
  }

  ...
}