for (int i = 0; i<=20; i++)
{
    temp = RandomNumber.nextInt(20) +1+i;
    if (!randomNumberArray.contains(temp))
    {
        {
            randomNumberArray.add(temp);
        }

    }

    System.out.println(randomNumberArray);
}