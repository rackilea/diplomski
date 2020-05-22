public class Animal
{
  public void eat(){}
}
public class Dog extends Animal
{
  public void eat(){}
  public void main(String[] args)
  {
    Animal animal=new Animal();
    Dog dog=(Dog) animal; //will not work
  }
}