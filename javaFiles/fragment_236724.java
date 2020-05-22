package com.stackOverflow.practice.banking;

public class Account {
      private String name;
      private double amount;

      public Account(String name, double amount) {
           this.name = name;
           this.amount = amount;

      }

      public double getAmount() {
           return this.amount;
      }

      public String getName() {
          return this.name;
      }

 }