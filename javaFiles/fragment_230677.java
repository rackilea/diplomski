String numone = null;
int temp = 0;
try
{
...
numone = stdIn.readLine();
temp = Integer.parseInt(numone) ;
System.out.println("Your temperature is " + temp + "ºC");
if (temp > 39) {
      System.out.println("You have fever! Go see a doctor!");
 }
else{
    System.out.println("Don't worry, your temperature is normal");
}
}
catch(..)
{
...
}