for (int j=0; j < 5; j++) //finds five lowest...array not assigned values
{
    for (int i=0; i < numbers.length; i++)
        {
            if (numbers[i] < min[j])
            {
                System.out.println("the value of numbers[i] is: " + numbers[i]);
                temp = numbers[i];
                numbers[i] = min[j];
                min[j] = temp;
            }
        }   
}