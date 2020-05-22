package com.foo;

public interface FooInterface { ... }

public class FooInterfaceFactory {
  public static FooInterface newFooInstance() {
    ServiceLoader<FooInterface> loader = ServiceLoader.load(FooInterface.class);
    Iterator<FooInterface> it = loader.iterator();
    // pick one of the provided implementations and return it.
  }