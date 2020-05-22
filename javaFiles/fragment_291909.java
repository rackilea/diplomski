ObjectContentManager ocm = getObjectContentManager();
// ------------------------------------------------------------------------
// Create a main object (a) with a null attribute (A.b)
// ------------------------------------------------------------------------
A a = new A();
a.setPath("/test");
a.setA1("a1");
ocm.insert(a);
ocm.save();

// ------------------------------------------------------------------------
// Retrieve
// ------------------------------------------------------------------------
a = (A) ocm.getObject("/test");
assertNotNull("Object is null", a);
assertNull("attribute is not null", a.getB());

B b = new B();
b.setB1("b1");
b.setB2("b2");
a.setB(b);

ocm.update(a);
ocm.save();