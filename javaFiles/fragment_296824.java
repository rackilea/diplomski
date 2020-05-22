double highest = 0;
int index = 0;
for (int i = 0; i < schools.length; i++)
{
  if (schools[i] > highest)
  {
    index = i;
    highest = schools[i];
  }
}
System.out.println("The school with the best attendance is school " + (index + 1) + " with " + highest + "% attendance");