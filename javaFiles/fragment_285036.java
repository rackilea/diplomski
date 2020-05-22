interface ISomething {
    void doSomething();
}

interface ISomething2 {
    void doSomething();
}

class Impl implements ISomething, ISomething2 {
   void doSomething() {} // There can only be one implementation of this method.
}