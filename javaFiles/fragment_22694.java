double largestNumber = Double.MIN_VALUE;
for(Number number: dua)
{
    if(number.doubleValue() > largestNumber)
        largestNumber = number;
}
System.out.println(largestNumber);