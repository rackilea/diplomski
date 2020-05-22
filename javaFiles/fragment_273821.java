String line = "\"USE CODE \"\"Gef, sdf\"\" FROM 1/7/07\", Delete , Hello , How are you ? , ";
String line2 = "Test asda ds asd, tesat2 . test3";
Pattern pattern = Pattern.compile("(?:\"[^\"]*(?:\"\"[^\"]*)*\"|[^,])+");
Matcher matcher = pattern.matcher(line);
if (matcher.find()){                        // if is used to get the 1st match only
    System.out.println(matcher.group(0)); 
}
Matcher matcher2 = pattern.matcher(line2); 
if (matcher2.find()){
    System.out.println(matcher2.group(0)); 
}