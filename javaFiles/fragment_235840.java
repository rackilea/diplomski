int[] maxAndCount = Arrays.stream(array).collect(
    () -> new int[2], // first max, then count
    (maxAndCount, i) -> {
      if (i > maxAndCount[0] || maxAndCount[1] == 0) {
        maxAndCount[0] = i;
        maxAndCount[1] = 1;
      } else if (i == maxAndCount[0]) {
        maxAndCount[1]++;
      }
    },
    (maxAndCount1, maxAndCount2) -> {
      if (maxAndCount1[0] < maxAndCount2[0]) {
        maxAndCount1[0] = maxAndCount2[0];
        maxAndCount1[1] = maxAndCount2[1];
      } else if (maxAndCount1[0] == maxAndCount2[0]) {
        maxAndCount1[1] += maxAndCount2[1];
      }
    });
  int count = maxAndCount[1];