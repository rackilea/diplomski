String s = "Hello World";
    Integer i = 5;
    Double d = 1.0 / 3;

    Object x = s;
    Object y = i;
    Object z = d;

    String res1 = caseType(x,
            of(String.class, v -> v.substring(0, 5)),
            of(Integer.class, v -> String.format("%d", v)),
            of(Double.class, v -> String.format("%1.4f", v)));

    String res2 = caseType(y,
            of(String.class, v -> v.substring(0, 5)),
            of(Integer.class, v -> String.format("%d", v)),
            of(Double.class, v -> String.format("%1.4f", v)));

    String res3 = caseType(z,
            of(String.class, v -> v.substring(0, 5)),
            of(Integer.class, v -> String.format("%d", v)),
            of(Double.class, v -> String.format("%1.4f", v)));

    String firstMatch = caseType(x,
            of(String.class, v -> "first case"),
            of(String.class, v -> "second case"));

    String resNull = caseType(z,
            of(String.class, v -> v.substring(0, 5)),
            of(Integer.class, v -> String.format("%d", v)));

    String resDefault = caseType(z,
            of(String.class, v -> v.substring(0, 5)),
            of(Integer.class, v -> String.format("%d", v)),
            of(Object.class, v -> "unknown"));

    String resSubtype1 = caseType(y,
            of(Number.class, v -> String.format("%1.4f", v.doubleValue())),
            of(Object.class, v -> "unknown"));

    String resSubtype2 = caseType(z,
            of(Number.class, v -> String.format("%1.4f", v.doubleValue())),
            of(Object.class, v -> "unknown"));

    System.out.println("res1:        " + res1);
    System.out.println("res2:        " + res2);
    System.out.println("res3:        " + res3);
    System.out.println("firstMatch:  " + firstMatch);
    System.out.println("resNull:     " + resNull);
    System.out.println("resDefault:  " + resDefault);
    System.out.println("resSubtype1: " + resSubtype1);
    System.out.println("resSubtype2: " + resSubtype2);