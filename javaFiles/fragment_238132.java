LongWrapper sum = new LongWrapper(0L);
for (int i = 0; i < Integer.MAX_VALUE; i++)
{
    sum.add(i);
}
System.out.println("Sum = " + sum);