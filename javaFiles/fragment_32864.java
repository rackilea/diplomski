public class MyConnectionProvider extends WhateverConnectionProviderYouAreUsing
  {
      public Connection getConnection()
      {
           try
           {
               return super.getConnection();
           } 
           catch (Exception e)
           {
               // Show message about connection error
           }
       }