public static void main(String[] args) {
    System.out.println(UUID.randomUUID().toString());
    System.out.println(RandomUtil.unique());

    System.out.println();
    System.out.println(Long.toHexString(0x8000000000000000L |21));
    System.out.println(Long.toBinaryString(0x8000000000000000L |21));
    System.out.println(Long.toHexString(Long.MAX_VALUE + 1));
}