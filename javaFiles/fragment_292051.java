int ctr=0, sum=0, ave = 0;
System.out.print("Enter number: ");
num[ctr]= input.nextInt();
while(num[ctr]!= -99)
{
   sum += num[ctr];
   ctr++;
   System.out.print("Enter number: ");
   num[ctr]= input.nextInt();
}