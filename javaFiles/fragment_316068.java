public getId(String name){
     try{
        if (nameMap1 == null)
            loadNameMap1();
        }
      catch (....){
          privateHelperFunctionThatCutsThisDownToOneLine(name, "id", "nameMap1");
      }
  }

  // you are left with the above repetitive three (or seven) lines,
  // but that is Java for you...
  // in return, you get nice, static compile-time error checking


 private void privateHelperFunctionThatCutsThisDownToOneLine(){
      // all the long repeated code in the exception handler
      // goes here.
 }