String text = "This is a string!   Is this a string?         I want to break it into sentences";
String[] parts = text.split("[?!.]\\s*"); 
for(String i: parts)
{
System.out.println(i);
}