public static void meanArray() {
    double result = 0;
    for(int i : list) {
        result += i;
    }
    result /= list.length;
    System.out.println(result);
}