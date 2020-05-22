abstract class Animal(name: String) {
  def sound(): String
  override def toString = "Animal"
}

class Cat(var name: String) extends Animal(name) {
  override def sound() = "meow"
}

class Dog(var name: String) extends Animal(name) {
  override def sound() = "woof"
}

object Park{
  def animals() =
    List(new Dog("Snoopy"), new Dog("Finn"), new Cat("Garfield"),new Cat("Morris"))

  def makeSomeNoise(lst :List[Animal]) :List[String] = lst.map(_.sound())
}

Park.makeSomeNoise(Park.animals())  
//res0: List[String] = List(woof, woof, meow, meow)