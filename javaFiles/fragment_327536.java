TestExtended sub = new TestExtended();
sub.mMember = 5;
System.out.println(sub.mMember); // prints '5', as expected

TestClass sup = sub; // this is fine, TestExtended extends TestClass
System.out.println(sup.mMember); // prints '0'!