Document doc = ...
Element script = doc.select("script").first(); // Get the script part


Pattern p = Pattern.compile("(?is)key=\"(.+?)\""); // Regex for the value of the key
Matcher m = p.matcher(script.html()); // you have to use html here and NOT text! Text will drop the 'key' part


while( m.find() )
{
    System.out.println(m.group()); // the whole key ('key = value')
    System.out.println(m.group(1)); // value only
}