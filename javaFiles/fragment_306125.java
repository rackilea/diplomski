num++;
if (num % 2 == 1) // make sure that num is even
    num++;

for(int i = 0; i < 10; i++)
{
    array[i] = num;
    num += 2; // jump to the next even number
}