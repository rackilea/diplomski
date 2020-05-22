if("s".equals(line) || "S".equals(line))
{
  // Don't need anything here.
}else {
  try
  {
       score = Double.parseDouble(line);                
       System.out.println(score);
  } catch( NumberFormatException nfe)
  {
  }
}