String example = "ThisShouldBeTwoElements.  ButItIsNot.";
String [] splitString = example.split(" ");
String recombined = "";
for(int i = 0; i < splitString.length; i++)
{
  if(!splitString[i].equals(" "))
    recombined += splitString[i];
}