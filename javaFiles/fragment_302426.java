for (int i = 0; i < numbers.length; i++) {
        for (int j = i; j < lottery.length; j++) {
            if (numbers[i] == lottery[j]) {
                counter++;
            }
        }
    }
    System.out.println("\n" + counter);