String temp;

for(int i = 0; i < SIZE; i++)
{
    temp = "";

    for(int j = SIZE - i; j <= SIZE ; j++) 
    {
        temp += j;
    }

System.out.printf("%" + SIZE + "s\n", temp);
}