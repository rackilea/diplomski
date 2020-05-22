String text = "Rupees Two Hundred Forty One and Sixty Eight only";
      int i = text.indexOf(" ", 35);
      if (i < 0) {
         i = text.length();
      }
      String part1 = text.substring(0,i).trim();
      String part2 = text.substring(i).trim();