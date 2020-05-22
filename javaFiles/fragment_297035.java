public static void main(String[] args) {
    String[] inputs = {"230Sq.feet", "110Sq.yards", "8Acres", "123Sq.Ft"};
    for(String input : inputs) {
        String[] fields = input.split("(?<=\\d)(?=[A-Z])");
        System.out.println(fields[0]+" "+fields[1]);
    }
}