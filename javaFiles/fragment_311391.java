// the first character cannot be a
System.out.println(Pattern.compile("[^a]bc").matcher("abc").find());        // false

// the first character cannot be x, y or z, but it can be a
System.out.println(Pattern.compile("[^xyz]bc").matcher("abc").find());      // true

// the first character can be ^ or a
System.out.println(Pattern.compile("[\\^a]bc").matcher("abc").find());      // true

// the first character can be ^, x, y or z, but not a
System.out.println(Pattern.compile("[\\^xyz]bc").matcher("abc").find());    // false