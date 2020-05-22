SomeClass<String> pam = new SomeClass<String>();

((SomeClass)pam).set(new Integer(0));

System.out.println(((SomeClass)pam).get()); // prints 0
System.out.println(pam.get()); // ClassCastException