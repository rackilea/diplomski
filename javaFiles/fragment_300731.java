for (int i = 0; i<=20; i++)
{
    do {
        temp = RandomNumber.nextInt(20) +1+i;
    } while (randomNumberArray.contains(temp));

    randomNumberArray.add(temp);

    System.out.println(randomNumberArray);
}