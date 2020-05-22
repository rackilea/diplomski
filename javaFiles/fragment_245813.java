public static void main(String[] args) {
    List<String> l = new Test().allVariants("igis", "eges");
    for (String x : l) {
        System.out.println(x);
    }
}