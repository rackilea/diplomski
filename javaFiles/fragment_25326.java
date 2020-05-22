try{
    d = df.parse(ds);
   }
catch(ParseException e){   
   e.printStackTrace();
   // log the exception
   throw new RuntimeException(e);
}