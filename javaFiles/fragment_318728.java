if (numbers[i] < min[j])
            {
                System.out.println("the value of numbers[i] is: " + numbers[i]);
                temp = numbers[i];
                numbers[i] = min[j];
                min[j] = temp;
            }