public static String substring(String s, int from, int to){
        Field f = String.class.getDeclaredField("value");
        f.setAccessible(true);
        char [] tab = (char[])f.get(s);
        f.setAccessible(false);
        return new String(tab, from, to - from);
}