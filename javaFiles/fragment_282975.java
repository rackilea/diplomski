volatile int i = 0;

THREAD A
{
   for (int j = 0; j < 1000; j++)
       i++;
} 
THREAD B
{
   for (int j = 0; j < 1000; j++)
       i++;
}