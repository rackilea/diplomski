do {
    numbers[counter] = keyboard.nextInt();
    if (numbers[counter] >= largest) {
       largest = numbers[counter];
       largest_i = counter;
    }
    counter++;
} while (counter < numbers.length);