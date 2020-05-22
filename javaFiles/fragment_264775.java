String example = " ";
    for (int i = 0; i < 5; i++) {
        if (i == 1 || i == 3) {
            example = example + "\nAnother text";
        }
    }
    System.out.println(example);