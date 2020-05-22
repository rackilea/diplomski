package com.test;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class TestGSON {
public static void main(String[] args) {
        Gson gson = new Gson();
        try{
            Object fromJson = gson.fromJson("{\"name\":\"Dharam\"}", Class.forName("com.test.MyClass"));
            if(fromJson instanceof MyClass){
                System.out.println(fromJson);
            }
        } catch (JsonSyntaxException | ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
    }
}

class MyClass {
private String name;

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

@Override
public String toString() {
    return "MyClass [name=" + name + "]";
}

}