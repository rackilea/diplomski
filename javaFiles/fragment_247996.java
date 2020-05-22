Pattern p = Pattern.compile("(\\d+)|([a-zA-Z]+)");
Matcher m = p.matcher("810LN15");
List<String> tokens = new LinkedList<String>();
while(m.find())
{
  String token = m.group( 1 ); //group 0 is always the entire match   
  tokens.add(token);
}
//now iterate through 'tokens' and check whether you have a number or text