class Animal {
    void eat() {}
}
class Dog extends Animal  {
    void bark() {}
}
class Pigeon extends Animal {
    void pick() {}
}
class MyFunction {
    void run() {
       Animal first = new Pigeon();
       // the following line will compile, but not run
       ((Dog)first).bark();
    }
}