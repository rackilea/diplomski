abstract class Animal<S extends Animal<S>> {
     S eat() { /* ... */ return (S)this; }
     S poo() { /* ... */ return (S)this; }
  }
  abstract class FootedAnimal<S extends FootedAnimal<S>> extends Animal<S> {
     S walk() { /* ... */ return (S)this; }
  }
  class Dog extends FootedAnimal<Dog> {
      Dog bark() { /* ... */ return this; }   
  }