int height = 0;
int weight = 0;
String name = "";

while (scanner.hasNextLine())   // use hasNextLine()  
{

 String line = scanner.nextLine();

 if(line.startWith("height "))  // do the same for weight 
 {
    line = line.replace("height ", "");
    try
    {
      height = Integer.parseInt(line);
    }
    catch(NumberFormatException e1)
    {

    }
 }

 else if(line.startWith("weight "))  // do the same for weight 
 {
   line = line.replace("weight ", "");
   try
   {
     weight = Integer.parseInt(line);
   }
   catch(NumberFormatException e1)
   {

   }
 }

 else if(line.startsWith("name "))
 {
   line = line.replace("name ", "");
   name = line;
 }

 else if(line.startsWith("team played for "))
 {
   line = line.replace("team played for ", "");

   String teamName = "";
   int i = 0;
   while(line.charAt(i) != ' ')
   {
      teamName = teamName + line.charAt(i); // copying the team name till space
      i++;
   }
   line = line.replace(teamName+" ","");
   // now we will be left with a string that contains start year 1 end year 2

   line = line.replace("start ", "");

   i = 0; // using the same i variable

   String startYear = "";

   while(line.charAt(i) != ' ')
   {
      startYear = startYear+ line.charAt(i);
      i++
   }
   line = line.replace(startYear+" end ", "");

   String endYear = line;
    // just make this as global variables if u need to use them in a different method also if you need to parse string to integer use  Interger.parseInt(String)

  }

  System.out.println("Name :-" + name);
  System.out.println("Weight :-" + weight);
  System.out.println("Height :-" + height);

}

// by now all the data has been stored to their respective variables