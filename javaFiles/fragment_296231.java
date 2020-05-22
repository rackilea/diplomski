String numbers = "123454321";
    System.out.println(numbers);
    for (int x = 5; x > 1; x--) {
        numbers = numbers.replace(Integer.toString(x), "_");
        System.out.println(numbers);
    }