MyObject object1 = new MyObject(30);
MyObject object2 = object1; //this will make them have the same reference

// This prints true, as they have the same content.
System.out.println(object1.equals(object2));

// This will print true, as they point the same thing, because they have the same reference
System.out.println(object1 == object2);

// We can see they have the same reference because if we edit one's field, 
// the other's one will change too.
object1.number = 10;
System.out.println(object1.number); // prints 10
System.out.println(object2.number); // prints 10 too