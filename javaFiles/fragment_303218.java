String[] numbers = ascend.split("\\s");
int intarray[] = new int[numbers.length];
int i = 0;
for (String numb : numbers)
{
    // convert the String to an int
    intarray[i++] = Integer.parseInt(numb);
}
Arrays.sort(intarray); // sort the int array, not the String array
System.out.println("---Ascending order---");
System.out.println(Arrays.toString(intarray));