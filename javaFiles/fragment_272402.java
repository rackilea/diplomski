String r10to99 = "[1-9][0-9]"; //numbers from 10 to 99
String r100to199 = "1[0-9][0-9]"; //numbers from 100 to 199
String r200to255 = "2[0-4][0-9]|25[0-5]"; //numbers from 200 to 255

//combine all - numbers from 0 to 255   
String r0to255 = "(?:[0-9]|" + r10to99 + "|" + r100to199 + "|" + r200to255 + ")"; 

String regexIP = r0to255 + "(?:[.]" + r0to255 + "){3}"; 

System.out.println("15.15.15.15".matches(regexIP)); // true
System.out.println("15".matches(regexIP)); // false