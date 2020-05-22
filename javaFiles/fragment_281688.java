class Test{
    public static void main(String[] args){
        String s = "a";
        char[] c = new char[]{'a'};
        StringBuffer buffer = new StringBuffer("a");

        char x;

        long time = System.nanoTime();
        for(int i = 0 ; i < 1000 ; i++)
            x = s.charAt(0);
        time = System.nanoTime() - time;

        System.out.println("string: " + time);

        time = System.nanoTime();
        for(int i = 0 ; i < 1000 ; i++)
            x = c[0];
        time = System.nanoTime() - time;

        System.out.println("[]: " + time);

        time = System.nanoTime();
        for(int i = 0 ; i < 1000 ; i++)
            x = buffer.charAt(0);
        time = System.nanoTime() - time;

        System.out.println("buffer: " + time);
    }
}