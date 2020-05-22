package com.test;

public interface Test {
    @DoSomething(pattern = "[%s]")
    void print(String value);
}