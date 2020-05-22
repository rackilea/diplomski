private mySomeClass;

public Foo(SomeClass mySomeClass)
{
    this.mySomeClass = mySomeClass;
}

public void method1(){
    if(mySomeClass != null)  mySomeClass.runSomething();
}