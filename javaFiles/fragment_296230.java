String numbers = "123454321";
    String[] remove = new String[]{"5", "4", "3", "2"};
    System.out.println(numbers);
    for (String current : remove) {
        numbers = numbers.replace(current, "_");
        System.out.println(numbers);
    }