for (int i = 0; i < numbers.length; i++)
    for (int j = i + 1; j < numbers.length; j++)
        for (int k = j + 1; k < numbers.length; k++)
            if (numbers[i] + numbers[j] + numbers[k] == sum)
                System.out.println("sum of %d + %d + %d gives %d\n",
                                   numbers[i], numbers[j], numbers[k], sum);