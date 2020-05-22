long number = 12345612;
int []frequency = new int[10];
while(number > 0)
{
 int digit = number % 10;
 number /= 10;
 frequency[digit] ++;
}

for(int i = 0; i < 10; ++i)
 System.out.println(frequency[i]);