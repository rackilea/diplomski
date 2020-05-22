package com.test;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
public class Interface1Impl implements IInterface1 {
    Map<String, IInterface2> i2 = new HashMap<String, IInterface2>();
    String a;
    String b;

    public Interface1Impl() {
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @XmlJavaTypeAdapter(I2Adapter.class)
    public Map<String, IInterface2> getI2() {
        return i2;
    }

    public void setI2(Map<String, IInterface2> i2) {
        this.i2 = i2;
    }
}