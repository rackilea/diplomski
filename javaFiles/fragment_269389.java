// ensures mod is positive
int mod(int a, int b)
{ return (a%b+b)%b; }

int numberCount = 4;
int rotationCount = 2 * numberCount;

for(int i = 0; i < rotationCount; i++)
{
    for(int j = 0; j < numberCount; j++)
    {
        System.out.print(mod((j-i), numberCount) + " ");
    }

    System.out.println();
}