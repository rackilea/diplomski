set = new set()
for (int i = 0; i < numbers.length; i++)
    for (int j = i + 1; j < numbers.length; j++) {
        num3 = sum - numbers[i] - numbers[j]
        if (num3 in set)
            print("sum of %d + %d + %d gives %d\n",
                  num3, numbers[i], numbers[j], sum);
    }
    add numbers[i] to set
}