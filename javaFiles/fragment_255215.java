String[] words = {"pay","car"};
String regex = ".*\\b" + String.join("\\b.*\\b", words) + "\\b.*";

String test1= "how much should i pay for the car?";
System.out.println(test1.matches(regex)); // True

String test2 = "bla bla car bla bla pay";
System.out.println(test2.matches(regex)); // False