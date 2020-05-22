for (int rows = 1; rows < height; rows += 2){

        for (int spaces =0; spaces < height - 1 - rows / 2; spaces++){
            System.out.print(" ");
        }

        for (int stars = 0; stars < rows; stars++){
            System.out.print("*");
        }

        System.out.println();
    }

        for (int rows = height - 2; rows > 0; rows -= 2){

        for (int spaces = 0; spaces < height - rows / 2 - 1; spaces++) {
            System.out.print(" ");
        }

        for (int stars = 0; stars < rows; stars++){
            System.out.print("*");
        }

        System.out.println();
    }