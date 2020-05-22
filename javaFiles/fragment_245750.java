int even = 0;
int odd = 0;

int[] array = new int[5];

for (int i=0; i<array.length; i++)
    if (array[i]%2 == 0)
        even++;
    else
        odd++;