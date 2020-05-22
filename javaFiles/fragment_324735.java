package com.stackOverflow;

import java.util.HashMap;

public abstract class Student {

    private String name ;
    private String address;
    private HashMap<Integer, Integer> testMarks;


    public Student(String name,String address) {
        this.name = name;
        this.address = address;
        testMarks.put(1, 0);
        testMarks.put(2, 0);
        testMarks.put(3, 0);

    }

     abstract void def();// no access modifier and hence it is in default state
}

package com.stackOverflow.Interface;

import com.stackOverflow.Student;

public class anumal extends Student {

    public anumal(String name, String address) {
        super(name, address);
        // TODO Auto-generated constructor stub
    }

    public void def() {
        System.out.println("hi");
    }

}