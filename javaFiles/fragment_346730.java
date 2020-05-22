package com.example;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@ViewScoped
public class Bean {

    private String value;
    private String oldValue;
    private String newValue;

    public void submit() {
        System.out.println("Submit: " + value);
    }

    public void change(ValueChangeEvent event) {
        oldValue = (String) event.getOldValue();
        newValue = (String) event.getNewValue();
        System.out.println("Change: " + oldValue + " to " + newValue);
    }

    public String getValue() {
        return value;
    }

    public String getOldValue() {
        return oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setValue(String value) {
        this.value = value;
    }

}