java.util.List<Double> list = new java.util.LinkedList<Double>(); // requires JRE >= 1.5
double input;
do 
{
  input = userinput.nextDouble();
  if (input >= 1 && input <= 100)
  {
    list.add(input);
  }
  else if (input != -1)
  {
    System.out.println("Please enter a valid mark (1-100)");
  }
}
while (input != -1);
Double[] array = list.toArray(new Double[list.size()]);

for (int counter = 0; counter < array.length; counter++)
{
  System.out.println(array[counter]);
}