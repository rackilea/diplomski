File file = new File("myfile.txt");
Scanner sc = new Scanner(file);
Pattern questionPattern = Pattern.compile("(^(.+\\?)(?=(\\s+(a\\.\\s+.+)"
        + "\\s+b\\.\\s+.+\\s+c\\.\\s+.+\\s+d\\.\\s+.+)))", Pattern.CASE_INSENSITIVE);
Pattern optionAPattern = Pattern.compile("((?<=(.+\\?\\s))(a\\..+)(?=(\\sb\\..+$)))");
Pattern optionBPattern = Pattern.compile("((?<=(\\s))(b\\..+)(?=(\\sc\\..+$)))");
Pattern optionCPattern = Pattern.compile("((?<=(\\s))(c\\..+)(?=(\\sd\\..+$)))");
Pattern optionDPattern = Pattern.compile("((?<=(\\s))(d\\..+)(?=(\\s*$)))");

if (sc.hasNextLine()) {
    String line = sc.nextLine();
    Matcher question = questionPattern.matcher(line);
    Matcher optionA = optionAPattern.matcher(line);
    Matcher optionB = optionBPattern.matcher(line);
    Matcher optionC = optionCPattern.matcher(line);
    Matcher optionD = optionDPattern.matcher(line);

    if(question.find()) System.out.println(question.group());
    if(optionA.find())  System.out.println(optionA.group());
    if(optionB.find())  System.out.println(optionB.group());
    if(optionC.find())  System.out.println(optionC.group());
    if(optionD.find())  System.out.println(optionD.group());
}