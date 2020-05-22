LongWrapper sum = new LongWrapper(0L);
for (int i = 0;i < Integer.MAX_VALUE; i++)
{
    sum.setValue(sum.getValue() + i);
}
System.out.println("Sum = " + sum);