private void printPermutations(int[] numbers) {
    for(int i=0;i<numbers.length; i++) {
      for (int j=i; j<numbers.length; j++) {
        System.out.println("[" + numbers[i] + "-"+ numbers[j] +"]");
      }
    }
  }