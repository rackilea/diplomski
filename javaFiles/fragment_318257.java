String s = "###### Heading6 Something here\r\n" +
           "###### More text \r\n" +
          "###Heading 3 text";
Matcher m = Pattern.compile("(?m)^#{6}(?!#)(.*)").matcher(s);
String result = m.replaceAll("<b>$1</b>");
System.out.println(result);