Integer i1 = 126;
    Integer i2 = 126;
    System.out.println(i1++ == i2++);// true
    System.out.println(i1 == i2); //true



 Integer i1 = 126;
        Integer i2 = 126;
        System.out.println(i1++ == i2++);// true
        System.out.println(i1.equals(i2)); //true

  Integer i1 = 128;
        Integer i2 = 128;
        System.out.println(i1++ == i2++);// false
        System.out.println(i1==i2); //false

  Integer i1 = 128;
        Integer i2 = 128;
        System.out.println(i1++.equals(i2++));// true
        System.out.println(i1.equals(i2)); //true