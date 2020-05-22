package com.amazonaws.lambda.demo;

public class RequestClass {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public RequestClass(String name) {
        this.name = name;
    }

    public RequestClass() {
    }
}