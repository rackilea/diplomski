Data[] temperatures = new Data[7]; // Indexes 0-6 (makes a total of 7 indexes)

// Start the loop from index 0, end it to index 6 (= temperatures.lenght)
for (int i = 0; i < temperatures.length; i++) {
    // Since it would sound strange to enter a temperature for day 0, notice (i+1)
    System.out.println("Please enter the temperature for day " + (i+1));
    temperatures[i] = new Data(input.nextDouble());
}