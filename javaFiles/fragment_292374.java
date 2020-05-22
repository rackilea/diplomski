public static void rotate(int[] seq, int times){

    System.out.println(java.util.Arrays.toString(seq));
    for (int i = 1; i <= times; i++) {
        seq = rotate(seq);
    }
}