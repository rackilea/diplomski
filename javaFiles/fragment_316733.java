int temp;
        for (int i = 0; i < (count - 1); i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) // '> for ascending order'
                {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }