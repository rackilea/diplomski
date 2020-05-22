public static List<Integer> printFactorsInt(int number) {
    List<Integer> listOfFactors = new ArrayList<>(); 

    for (int i = 1; i <= number; i++) {
        if ((number % i) == 0) {
            listOfFactors.add(i);
        }
    }
    return listOfFactors;
}