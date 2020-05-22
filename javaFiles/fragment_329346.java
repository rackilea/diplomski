public static void main(String[] args) {
    int count = 0;
    NUMBERS:
    for (int num = 12; num <= 54321; num += 12) {
        Set<Integer> digits = new HashSet<>();
        int tempNum = num;
        while (tempNum != 0) {
            int digit = tempNum % 10;
            if (!digits.add(digit)) {
                continue NUMBERS;
            }
            tempNum = tempNum / 10;
        }
        ++count;
    }
    System.out.println("There are "+count+" numbers satisfying the condition");
}