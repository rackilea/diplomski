// declaration
    String a = "a";
    String b = "a";
    String c = new String("a");

    // check references 
    System.out.println("AB>>" + (a == b));  // true, a & b references same memory position
    System.out.println("AC>>" + (a == c));  // false, a & c are different strings
    // as logic states if a == b && a != c then b != c.

    // using equals
    System.out.println("ACe>" + (a.equals(c))); // true, because compares content!!!!

    // using intern()
    System.out.println("ABi>" + (a.intern() == b.intern()));  // true
    System.out.println("BCi>" + (b.intern() == c.intern()));  // true