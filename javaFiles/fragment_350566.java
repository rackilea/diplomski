package com.test.bean;

import java.io.Serializable;

import com.test.data.Employee;

public class FormBean implements Serializable {

    private static final long serialVersionUID = -1042911106119057617L;

    public void save(Employee employee) {

        System.out.println("Keep in  mind: Save will only be entered if no validation errors! JSF Lifecycle!");
        System.out.println(employee.getEmail());

    }

}