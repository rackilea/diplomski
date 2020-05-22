package com.mycompany.foos.impl
public class FooFactory {
    private static class FooImpl implements IFoo1 {
        ...
    }
    public static IFoo getFoo() {
        return new FooImpl();
    }
}