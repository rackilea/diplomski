class Test {

    static Random r = new Random();

    public static void main(String[] a) {

        for (int i = 0; i < 10; i++) {
            System.out.println(getNewCode());
        }
    }

    private static String getNewCode() {
        Character[] array = new Character[6];

        int i = 0;
        while(i < 4) array[i++] = (char) ('0' + r.nextInt(10));

        array[4] = (char) ('a' + r.nextInt(26));
        array[5] = (char) ('a' + r.nextInt(26));

        List<Character> l = Arrays.asList(array);

        Collections.shuffle(l);

        StringBuilder sb = new StringBuilder();

        for (char s : l)
            sb.append(s);

        return sb.toString();
    }
}