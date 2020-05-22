Pattern p = Pattern.compile("\\<!\\[CDATA\\[|\\]\\]>"); 
    String s = "<![CDATA[<explanation>SomeText Here</explanation>]]>";
    Matcher m = p.matcher(s); 
    String extracted = "";

    while (m.find()) { 
       extracted = m.replaceAll("");
    }


        System.out.println(extracted );