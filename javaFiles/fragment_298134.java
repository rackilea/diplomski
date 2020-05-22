System.out.println(match("blub : test : 100 : 111")); // true
System.out.println(match("1 : 1 : 1 : 1")); // true
System.out.println(match("blub : test : foo : bar")); // false
System.out.println(match("blub : test : 0.1 : 0.1")); // false
System.out.println(match("this is another : test : 100 : 111")); // true
System.out.println(match("!\"§$%&/()=?) : .; : : : ; : 100 : 111")); // true
System.out.println(match(" :  : 100 : 111")); // false