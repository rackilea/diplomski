package com.test;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Grade {



    public Grade(String grade) {
        super();
        this.grade = grade;
    }

    @Expose @SerializedName("GRADE") 
    private String grade;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }



}