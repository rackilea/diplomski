public static void sentence(String sen) {
    String[] array = sen.split(" ");
    String[] five = Arrays.copyOfRange(Array, 0, 5);

    if (Array.length < 6)
        System.out.println(sen);
    else
        System.out.print(String.join(" ",five));
}