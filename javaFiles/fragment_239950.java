while (inputNumber > 0) {
        if (inputNumber<4 || inputNumber>10) {
            System.out.println("Invalid grade!");
        } else {
            sum += inputNumber;
            count++;
        }
        System.out.print("Input a grade (4-10): ");
        inputNumber = reader.nextInt();
    }