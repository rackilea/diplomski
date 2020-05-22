String[] numbers = {"One", "Two", "Three", ...};
Object[][] data = new Object[numbers.length][];
for (int i = 0; i < numbers.length; i++) {
    if (i % 2 == 0) {
        data[i] = new Object[]{numbers[i], Boolean.TRUE};
    } else {
        data[i] = new Object[]{numbers[i], Boolean.FALSE};
    }
}