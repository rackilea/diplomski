int number = 0;
int number_2 = 0;

//going forwards:
for (int i = 0; i < array.length; i++)
{
    number = number * 10 + array[i];
}

//going backwards:
for (int i = array.length - 1; i >= 0; i--)
{
    number_2 = number_2 * 10 + array[i];
}

if (number == number_2)
{
    //you have a palindrome
}