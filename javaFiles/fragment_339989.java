public MyClass()
{
    <String>doWhatEver("Test Me2!"); //does not compile
    doWhatEver("Test Me2!"); //compile
}

public <T> void doWhatEver(T x){
    System.out.println(x);
}