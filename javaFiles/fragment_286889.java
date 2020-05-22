public class Animal {}
public class Dog extends Animal {}

Animal pet = new Dog(); // pet is actually a Dog, but the compiler only knows that it is an Animal

Dog myBestFriend = (Dog) pet; // tell the compiler to assume that pet is really a Dog, allowing us to assign it to a Dog-typed variable.