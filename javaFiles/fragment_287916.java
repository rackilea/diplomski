public static double median(int[] numbers) {
      Arrays.sort(numbers); // sort numbers
      int len = numbers.length;

      if (len % 2 == 0) // length is even
          return (numbers[len/2] + numbers[len/2-1]) / 2.0d;

      else // length is odd
          return (double) numbers[len/2];

}