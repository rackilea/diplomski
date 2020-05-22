private static String mainId;

@BeforeClass
public static void init() { //must be public static void
    String numeric = randomNumeric();
    mainId = "D1234" + numeric;
}

@Test
public void somethingA() {
    //use mainId (note that it belongs to class, not this instance)
    //...
}

//other tests...