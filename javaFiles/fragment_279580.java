public abstract class Animal{
  public abstract void fooMethod();
}

public abstract class Pet extends Animal{
  public abstract void breed();
  public abstract void gender();
}

public class Reptile extends Animal{
  public void fooMethod(){}
}
public class Cat extends Pet{ //do the same for Dog
  public void fooMethod(){}
  public void breed(){}
  public void gender(){}
}