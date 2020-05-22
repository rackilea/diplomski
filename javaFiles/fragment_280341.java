char[] concatenatedArray = new char[l1+l2];

for (i =0;i <l1;i++)
{
    concatenatedArray[i] = ab[i];
}

for (i =0;i <l2;i++)
{
    concatenatedArray[l1+i] = cd[i];
}
System.out.println(concatenatedArray);