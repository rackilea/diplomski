String s = "[2017-08-17 08:00:00 Comming in [Contact:NO] [REF:] [REF2:] [REF3:] [Name:+AA] [Fam:aa] [TEMP:-2:0:-2:0:-2] [Resident:9:free] [end:0:]";
Pattern pat = Pattern.compile("^\\[*(\\d[\\d: -]+\\d).*?\\[Name:([^]]*)].*?\\[Fam:(\\w*)].*?\\[Resident:\\w*:([^]]*)]");
Matcher matcher = pat.matcher(s);
if (matcher.find()){
    System.out.println("Date: " + matcher.group(1));
    System.out.println("Name: " + matcher.group(2)); 
    System.out.println("Fam: " + matcher.group(3)); 
    System.out.println("Resident: " + matcher.group(4)); 
}