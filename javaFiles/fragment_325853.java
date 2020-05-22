package com.example.athletics;

import java.util.Date;

public class Athlete {
// Object fields
    int code;
    String Name;
    String surName;
    Date birthDate;

    public Athlete(){}
    // TODO methods to identify the Athlete

    public boolean equals(Athlete other) {
        if (other == null) {
            return false;
        } else {
            return code == other.getCode();
        }
    }

    public int getCode() {return code;}
}