public class DummyWrapper {
val foo get() = DummyCompanion.Companion

public void callAStaticMethod(){
    foo.staticMechod();
}

public void callCompanionMethod(){
    foo.someCompanionMethod();
}
}