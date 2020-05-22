private int calculateLevelR() {
      int sum = 0;
      for (Integer mark: marks) {
          if(mark < 50)
              sum++; // If mark is less than 50 increment sum
      }
      return sum; // finally when check all marks return sum, this sum will represent total number of marks less than 50.
  }