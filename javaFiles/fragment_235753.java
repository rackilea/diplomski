class Test {

    static Random r = new Random();

    public static void main(String[] a) {

        for (int i = 0; i < 10; i++) {
            System.out.println(getNewCode());
        }
    }

    private static String getNewCode() {
        List<Character> l = new ArrayList<Character>();

        int i = 0;
        for(int i = 0; i<4; i++)
            l.add((char) ('0' + r.nextInt(10)));

        l.add((char) ('a' + r.nextInt(26)));
        l.add((char) ('a' + r.nextInt(26)));

        Collections.shuffle(l);

        StringBuilder sb = new StringBuilder();

        for (char s : l)
            sb.append(s);

        return sb.toString();
    }
}