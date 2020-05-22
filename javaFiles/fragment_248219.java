String strLine = "93.38.31.43 and 39.53.19.33 and lala.lala.lala.lala";
String input = "*.*.*.*";
String replaceWord = "[censor]";

input = input.replace("*","\\w+").replace(".", "\\.");
System.out.println(input); // \w+\.\w+\.\w+\.\w+

strLine = strLine.replaceAll("\\b" + input + "\\b", replaceWord);
System.out.println(strLine);
//=> [censor] and [censor] and [censor]