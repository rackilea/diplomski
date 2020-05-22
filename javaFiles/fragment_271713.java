Element script = doc.select("script").first();  //to get the script content
Pattern p = Pattern.compile("\"title\":\"(.+?)\""); // Regex for the getting the string: "title":"blah blah blah" 
Matcher m = p.matcher(script.html());

while(m.find())
{
    System.out.println(m.group()); 
}