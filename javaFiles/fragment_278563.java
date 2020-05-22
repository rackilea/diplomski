myString = myString
          .replaceAll("\\b1\\b", "one") // replace 1 by one
          .replaceAll("\\b2\\b", "two") // replace 2 by two
          .replaceAll("\\s*\\d+", "");  // remove all digits

//=> Happy New Year, it's one January now,two January tommorow