public static Currency createCurrency (String country) {
   if (country. equalsIgnoreCase ("India")){
          return new Rupee();
   }else if(country. equalsIgnoreCase ("Singapore")){
          return new SGDDollar();
   }else if(country. equalsIgnoreCase ("US")){
          return new USDollar();
    }else if(country. equalsIgnoreCase ("all")){
          return new AllCurency(new Rupee(),new SGDDollar(),new USDollar());
    }
   throw new IllegalArgumentException("No such currency");
   }