public class Parent {
    public String getString () { return ""; }
}

public class StringlessChild extends Parent {
    @Override public String getString () { return "nothing"; }
}

public class StringedChild extends Parent {
    @Override public String getString () { return "a string"; }
}