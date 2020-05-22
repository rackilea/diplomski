String bin1 = "10110110";
      int dec1 = 0;
      // Iterate over the characters, left to right (high to low)
      for (char b : bin1.toCharArray()) {

         // convert to a integer by subtracting off character '0'.
         int bit = b - '0';

         // validate
         if (bit < 0 || bit > 1) {
            throw new IllegalArgumentException("Not a binary number");
         }
         // going left to right, first multiply by 2 and then add the bit
         // Each time thru, the sum will be multiplied by 2 which shifts everything left
         // one bit.
         dec1 = dec1 * 2 + bit;
      }

      System.out.println(dec1); // prints 182