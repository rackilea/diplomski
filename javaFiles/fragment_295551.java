Color theColor = getColor()
String colorName = null;
if (Color.BLACK.equals(theColor)) 
{
  colorName = "BLACK";
} 
else if (Color.WHITE.equals(theColor)) 
{
  colorName = "WHITE";
}
...
System.out.println(colorName);