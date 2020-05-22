String sentence = "The student John with the number 1 is smart.";
String pattern = "The student (\\w+) with the number (\\d+) is smart.";

Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(sentence);

if(m.find()) {
    System.out.println("Name: " + m.group(1));
    System.out.println("Number: " + m.group(2));
}