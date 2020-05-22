String letterPart = input.substring(0,3);
String numberPart= input.substring(3,7);
String rest = input.substring(7);

letterPart = letterPart.replace("0", "O");

numberPart = numberPart.replace("o", "0");
numberPart = numberPart.replace("Ï", "1");
numberPart = numberPart.replace("Z", "2");