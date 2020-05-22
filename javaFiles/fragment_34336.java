// generate some test data
      Random r = new Random(23);
      String[] bitStrings =
            r.ints(20, 20, 4000).mapToObj(Integer::toBinaryString).toArray(
                  String[]::new);

      for (String bitstr : bitStrings) {
         int v = baseToInt(bitstr, 2);
         String hex = intToBase(v, 16);
         System.out.printf("%12s = %s%n", bitstr, hex);
      }