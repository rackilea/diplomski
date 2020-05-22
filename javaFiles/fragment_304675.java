String[] words = text.split(" ");
      int k;
      part1 = words[0];
      for (k = 1; k < words.length; k++) {
         if (part1.length() >= 35 - words[k].length()) {
            break;
         }
         part1 += " " + words[k];
      }
      if (k < words.length) {
         part2 = words[k++];
         while (k < words.length) {
            part2 += " " + words[k++];
         }
      }
      System.out.println(part1);
      System.out.println(part2);