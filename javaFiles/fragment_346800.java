public static void main(String[] args) {

    int [] intArrayCapital = new int[26];
    int [] intArrayLower = new int[26];

    for(int i = 0; i < 26; i++) {               
        intArrayCapital[i] = 'A' + i;
        intArrayLower[i] = 'a' + i;
    }

    System.out.println(Arrays.toString(intArrayCapital));
    System.out.println(Arrays.toString(intArrayLower));
}