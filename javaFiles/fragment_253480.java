package com.person;

import java.io.Serializable;

    public class PersonBean implements Serializable {

        private String name="Hello World";
        public PersonBean()
       {
        this.name="Hello";
       }
       public void setName(String name)
       {
        this.name = name;
       }
       public String getName()
       {
        return name;
       }
    }