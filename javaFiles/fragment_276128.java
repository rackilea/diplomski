int dec = 0;
      int mult = 1;
      int bin = 10110110; // 128 + 48 + 6 = 182.
      while (bin > 0) {
         // get the right most bit
         int bit = (bin % 10);

         // validate
         if (bit < 0 || bit > 1) {
            throw new IllegalArgumentException("Not a binary number");
         }

         // Sum up each product, multiplied by a running power of 2.
         // this is required since bits are taken from the right.
         dec = dec + mult * bit;
         bin /= 10;
         mult *= 2; // next power of 2
      }
      System.out.println(dec); // prints 182