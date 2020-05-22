class A {}
class B extends A{}

fieldType = A.class;

//this would throw an exception since A it NOT a B!
(B)fieldType.newInstance();