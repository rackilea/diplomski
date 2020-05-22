package com.autowire;
    public class Employee {

        private String name;
        private String country;

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(final String country) {
            this.country = country;
        }

        public void show() {
            System.out.println("hai my country is: " + country);
            System.out.println("hai my name is: " + name);
        }
    }