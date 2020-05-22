String s= "The#red#studio#502#4";
String[] array = s.split("#(?=[0-9])");
for(String str : array)
{
  System.out.println(str.replace('#',' '));
}