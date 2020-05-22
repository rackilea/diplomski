public int calcHandTotal() {
      int total = 0;

      for(int i = 0; i < cCount; i++) {
          total += deck[i].Value();
      }

      return total;
  }