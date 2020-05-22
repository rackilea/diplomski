Derived d = new Derived(1);
System.out.println(d.getValue());  // 1
Base b = d;                        // We don't need an explicit cast
b.setValue(2);                     // Set the value via `b`
System.out.println(d.getValue());  // 2 -- note we're getting via `d`
Derived d2 = (Derived)b;           // Explicit cast since we're going more specific;
                                   // would fail if `b` didn't refer to a Derived
                                   // instance (or an instance of something
                                   // deriving (extending) Derived)
d2.setValue(3);
System.out.println(d.getValue());  // 3 it's the same object
System.out.println(b.getValue());  // 3 we're just getting the value from
System.out.println(d2.getValue()); // 3 differently-typed references to it