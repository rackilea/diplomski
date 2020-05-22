String content = new Scanner(new File("file.txt")).useDelimiter("\\Z").next();//<----(1)

Pattern pattern = Pattern.compile( Pattern.quote("commercial") 
 + "(.*?)" + Pattern.quote("|"));//<-----(2)
Matcher matcher = pattern.matcher(content);
String[] result;
while (matcher.find()) {
   result = matcher.group(1).replaceAll("[^a-zA-Z0-9 ]", "").trim().split("\\s+");//<--(3)
    System.out.println(Arrays.toString(result));
}