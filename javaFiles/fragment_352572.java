public void setType(String theType){

      type = theType;          

      if ( "special".equals(type) ){
              mySpecialValue = 0;
      } else {
              mySpecialValue = makeUniqueInt(); // eg. some date twiddling
      }

 }