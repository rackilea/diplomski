package com.myvalidation;

public class MyValidationClass extends ActionSupport
{
     public String emailVerification() throws Exception
     {
         //Your validation logic for email validation
         return SUCCESS;
     }

     public String passVerification() throws Exception
     {
         //Your validation logic for password validation
         return SUCCESS;
     }
}