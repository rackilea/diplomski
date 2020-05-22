interface Actionable{
    public void action;
}

class Base;
class Foo extends Base implements Actionable;
class Bar extends Base implements Actionable;

interface IService {
   void action(Actionable a);
}

class FooService implements IService {
   void action(Actionable a) {
    ...
   }
}

class BarService implements IService {
   void action(Actionable a) {
    ...
   }
}