String text = "manoj kumjjjartiwarimanojmanoj";

Pattern p = Pattern.compile("manoj");
Matcher m = p.matcher(text);
int count = 0;
while (m.find())
{
   count +=1;
}