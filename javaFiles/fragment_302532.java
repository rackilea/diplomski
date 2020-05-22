String line = "21Sid1\nOrdernr Skip everything upto new line\nE17222\nBy\nSeller";
Pattern pattern = Pattern.compile("Ordernr.*[\r\n]+(.*)");
Matcher matcher = pattern.matcher(line);
if (matcher.find()) {
    System.out.println("group 1: " + matcher.group(1));
}else{
    System.out.println("No match found");
}