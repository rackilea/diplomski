String regex="\\d{1,5}([.]\\d{1,3}|(\\s\\d{1,5})?[/]\\d{1,3})?";

System.out.println("12345 12/12".matches(regex));   //OK
System.out.println("123/123".matches(regex));       //OK
System.out.println("123.123".matches(regex));       //OK
System.out.println("12345".matches(regex));         //OK
System.out.println("123 /123".matches(regex));      //fail
System.out.println("123 .123".matches(regex));      //fail
System.out.println("/123".matches(regex));          //fail
System.out.println("123/".matches(regex));          //fail
System.out.println("123.".matches(regex));          //fail
System.out.println(".123".matches(regex));          //fail