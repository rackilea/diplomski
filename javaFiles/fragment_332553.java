public interface ISomething {
    public void mySomething();
}

public ExtendA extends A implements ISomething {
    public void mySomething() { something(); }
}

public ExtendB extends B implements ISomething {
    public void mySomething() { something(); }
}