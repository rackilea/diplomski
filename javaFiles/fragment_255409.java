package com.abaghel.examples;

import java.io.Serializable;
import java.util.ArrayList;

public class OuterClass implements Serializable {
int id;
ArrayList<InnerClass> listofInner;

public int getId() {
    return id;
}

public void setId(int num) {
    this.id = num;
}

public ArrayList<InnerClass> getListofInner() {
    return listofInner;
}

public void setListofInner(ArrayList<InnerClass> list) {
    this.listofInner = list;
}

public static class InnerClass implements Serializable {
    String streetno;

    public void setStreetno(String streetno) {
        this.streetno = streetno;
    }

    public String getStreetno() {
        return streetno;
      }
    }
}