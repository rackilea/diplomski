static double[][] shuffleArray(double[][] input_array)
  {  
    Random rnd = new Random();
    for (int i = input_array.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      double[] container = input_array[index];
      input_array[index] = input_array[i];
      input_array[i] = container;
    }
    return input_array;
  }