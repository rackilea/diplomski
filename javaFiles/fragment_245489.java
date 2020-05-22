$ javac Main.java
Main.java:7: inconvertible types
found   : java.lang.Class<java.lang.Void>
required: Class
        System.out.println(Void.class instanceof Class);
                               ^
Main.java:8: inconvertible types
found   : java.lang.Class<java.lang.Void>
required: Class
        System.out.println(Void.TYPE instanceof Class);
                               ^
2 errors
$ rm Class.class
$ javac Main.java
$ java Main
true
true