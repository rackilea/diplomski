String testString  = "bad";  
String givenString = "xxbad";  


boolean zeroIndexMatch = givenString.regionMatches(true, 0, testString, 0, 3);  
boolean firstIndexMatch = givenString.regionMatches(true, 1, testString, 0, 3);  

if (zeroIndexMatch || firstIndexMatch) {  
    System.out.println(true);  
} else {  
    System.out.println(false);
}