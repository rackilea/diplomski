package com.test;

import java.util.Map;

public interface IInterface1 {
    Map<String, IInterface2> getI2();

    String getA();

    String getB();

    void setA(String a);

    void setB(String b);

    void setI2(Map<String, IInterface2> i2);
}