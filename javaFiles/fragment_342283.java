B b = new B();
b.setId(1000); //Assuming that you know the id. 
               //There is no necessary fill all the object. Just the PK is needed.
A a = new A();
a.setId(100);
a.setAValue("nothing");
a.setB(b);
em.persist(a);