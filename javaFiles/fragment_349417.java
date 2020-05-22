int temp = 0;
for (int i = 0; i < array.length / 2; i++)
{
    int temp = array[i];
    array[i] = array[array.length - i--];
    array[array.length - i--] = temp;
}