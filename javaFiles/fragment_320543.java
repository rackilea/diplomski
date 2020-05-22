static List<Integer> sumDigPow(int a, int b) {
    List<Integer> eureka = new ArrayList<Integer>(0);
    String num;
    int sum = 0, multi;

    for (int i = a; i <= b; i++) {
        num = String.valueOf(i);
        for (int j = 0; j < num.length(); j++) {
            multi = (int) Math.pow(Character.getNumericValue(num.charAt(j)), j + 1);
            sum += multi;
        }

        if (sum == i) {
            eureka.add(i);
        }
        sum = 0;
    }
    return eureka;
}