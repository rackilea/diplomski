class Animal {
        public void m() {System.out.println("AAA");}
  }
  class Bee extends Animal {
        public void m() {System.out.println("BBB"); }
  }

class Test{
public static void main(String [] args){
    Animal a=new Animal();
    Bee b=new Bee();
    Animal x;

    x=a; x.m(); // "AAA" a is an animal
    x=b; x.m(); // "BBB" b is a Bee, so it's an Animal

    a=b; a.m();   // "BBB" A Bee is an Animal
    b=a; b.m();   // ERROR An Animal is a Bee? What if it's a Cat?
}}