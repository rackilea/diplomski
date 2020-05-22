System.out.println("The numbers are:");
double sum = 0; //new variable
for(int i = 0; i < length; i++)
{
    num[i] = reader.nextDouble();
    sum += num[i];
    System.out.println(num[i]);
}
sum /= (double) length; //divide by n to get the average
System.out.print("Average : ");
System.out.println(sum);