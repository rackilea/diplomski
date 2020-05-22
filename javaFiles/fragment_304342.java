public static void main(String[] args) {
        //Using Java Reflection...I tried to create an inner class Object
        //created a outer class object
        //and invoke the method without any success
               Private p = new Inner ().new Private ();
           System.out.println(""+p.getMeSomething(21));
       }