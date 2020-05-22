Integer a = 101;
    Integer b = 101;
    Integer c = 1234;
    Integer d = 1234;
    Integer e = a;


    System.out.println(a==b); //true - same reference; for explanation read the attached link
    System.out.println(a==e); //true - same reference; 'e' referencing 'a'
    System.out.println(c==d); //false - diffrent reference
    System.out.println(c.equals(d)); //true - meaningfully equals