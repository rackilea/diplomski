public static void main(String[] args) {
    System.out.println(
        Arrays.stream(new double[]{1,2.0,4,5,6,7.0})
            .average()
            .getAsDouble()
    );
}