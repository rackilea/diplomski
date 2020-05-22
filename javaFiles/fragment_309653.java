String fName = "shaik II .SR IV";
String[] genSuffixFname = fName.split("\\s+");
System.out.println(genSuffixFname.length);

if (genSuffixFname.length >= 2) {
    String line = fName; 
    String pattern = "(II)|(III)|(IV)|(V)|(VI)|"
                + "(VII)|(VIII)|(ESQ)|(.JR)|(.SR)";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(line); 
    while (m.find()) {
        System.out.println(m.group());
    }
}`