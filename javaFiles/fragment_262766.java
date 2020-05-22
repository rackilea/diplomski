private int calculateLevelR() {
      int sum = 0;
      for (Integer mark: marks) {
          if(mark < 50)
              sum += mark;
          sum = marks.size(); // If mark is less than 50 add mark to sum else sum = size of arrayList
      }
      return sum;
  }