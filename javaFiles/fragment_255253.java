double[] array = new double[1000000];
int count = 0;
do 
{
  input = userinput.nextDouble();
  if (input >= 1 && input <= 100)
  {
    if (count < array.length) array[count++] = input;
  }
  else if (input != -1)
  {
    System.out.println("Please enter a valid mark (1-100)");
  }
}
while (input != -1);

for (int counter = 0; counter < count; counter++)
{
  System.out.println(array[counter]);
}