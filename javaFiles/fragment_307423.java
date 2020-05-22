List<Derived> x = new ArrayList<Derived>();

// This is valid...
List<? extends Base> y = x;

// This is what you *want* to be valid
List<Base> z = y;

z.add(new Base());

// This looks fine at compile-time... but what would you expect it to do?
Derived d = x.get(0);