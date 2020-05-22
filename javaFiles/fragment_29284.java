int sum = 0;
for(int i=0; i<contents.size(); i++)
{
    String[] split = (String[])contents.get(i);
    sum  += getAge(split[0]); // After changing getAge to return an int
}
System.out.println(sum);