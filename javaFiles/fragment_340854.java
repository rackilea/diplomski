IntStream.range(0, 1000)
         .peek(i -> {
             if (i + 1 % 100 == 0) {
                 System.out.println("Test number " + i + " started.");
             }
         }).forEach(i -> {/* the test */});