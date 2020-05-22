public static void main(String[] args) throws Exception {
    StoreKey one = StoreKey.of(1, 2, 3);
    StoreKey two = StoreKey.of(1, 2, 3);

    System.out.println(one.equals(two)); // <<--- yields true
}