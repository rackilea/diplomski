abstract class ParentClass{
   ...
}

class ChildClass extends ParentClass {

   public void SomeChildMethod(){ ... }
   ...
}

...


ChildClass obj1 = new ChildClass(5);
ParentClass obj2 = new ChildClass(5);

obj1.SomeChildMethod(); // ok
obj2.SomeChildMethod(); // compilation error 
((ChildClass)obj2).SomeChildMethod(); // ok