String text = "This IS My TEXT StrinG";
int upperCaseCounter = 0;
int lowerCaseCounter = 0;
for (int i=0; i<text.length(); i++)
   {
   if (Character.isUpperCase(text.charAt(i)))
      {
       upperCaseCounter++;
      }
   else if(Character.isLowerCase(text.charAt(i)))
     {
       lowerCaseCounter++;
     }
 }

System.out.println("Total Uppercase Characters: " + upperCaseCounter);
System.out.println("Total Lowercase Characters: " + lowerCaseCounter);