abstract class Animal {
     Animal eat() { /* ... */ return this; }
     Animal poo() { /* ... */ return this; }
  }
  abstract class FootedAnimal extends Animal {
     FootedAnimal walk()  { /*...*/ return this; }
  }
  class Dog extends FootedAnimal {
      Dog bark() { /* ... */ return this; }   
  }