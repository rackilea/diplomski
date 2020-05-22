int[] countingArray = new int[10];
for (int countOfGenerator = 0; countOfGenerator < 100; countOfGenerator++) {
    // Get a number between 0 and 9 (inclusive); we'll add 1 to it in a moment
    int number = numberGenerator.nextInt(10);

    // Update your counts (array indexes start at 0, which is why we
    // haven't added to `number` yet)
    countingArray[number]++;

    // Store the actual number, which we add to because the assignment
    // is for 1-10, not 0-9
    arrayOfGenerator[countOfGenerator] = number + 1;
}