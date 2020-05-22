public static void run()
{
//anything....
ArrayList<Integer> list = new ArrayList<>();
println("");
println("Leap years according to the Gregorian calendar from "+y1+" to "+y2+":");
println("");
for(Integer year=y1; year<=y2; year++) //Prints all years from user range.
{
   if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) //Prints only leap years from user range.
   {
        list.add(year);
   }
}
//Loop and print size() and all leap years here