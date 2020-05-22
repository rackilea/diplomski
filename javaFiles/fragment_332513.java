package com.example.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Load {

    private int one;
    private int five;
    private int fifteen;

    public int getOne() {
        return one;
    }

    public void setOne(int one) {
        this.one = one;
    }

    public int getFive() {
        return five;
    }

    public void setFive(int five) {
        this.five = five;
    }

    public int getFifteen() {
        return fifteen;
    }

    public void setFifteen(int fifteen) {
        this.fifteen = fifteen;
    }

}