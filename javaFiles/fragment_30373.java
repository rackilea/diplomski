public String myFunction(String value){
          value = "toto";
          return value; // The value modified is return back to the caller
       }

       public static void main(String[] args) {
           MyClass myClass = new MyClass();
           String myValue = myClass.myFunction(myvalue); // The new value is saved
       }
 }