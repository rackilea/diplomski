public static void main(final String[] args)
    {
        final List<String> al = new ArrayList<String>(100);
        for (int i=0; i<100; i++) { al.add("Hello World!"); }
        for (final String s : al)
        {
            System.out.println(al.indexOf(s));
        }
    }