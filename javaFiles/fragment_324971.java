String string1="[1,2,3]~[4,5,6]~[7,8,9]~";
String string2 = string1.replace("[","").replace("]","");

for(int i = 0; i < stringArray.length; i++)
{
   String s = stringArray[i].substring(1, stringArray[i].length()-1);
   String[] elementArray = s.split(",");
   for(int j = 0; j < elementArray.length; j++)
   {
       int val = Integer.parseInt(elementArray[j]);
       intArray[i][j] = val;
   }
}