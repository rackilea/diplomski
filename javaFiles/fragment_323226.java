boolean firstCheck = 1 > 2;
boolean secondCheck = 2 < 3;
boolean thirdCheck = "hello".equals("Hello");

System.out.println("First check is: " + firstCheck);
System.out.println("Second check is: " + secondCheck);
System.out.println("Third check is: " + thirdCheck);

if (firstCheck && secondCheck && thirdCheck) {
    //Do something
}