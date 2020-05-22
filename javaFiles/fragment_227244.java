class MyComp implements Comparator<String> {
    public int compare(String a ,String b) {
        /*
        System.out.println(a+"  "+b);
        String aStr,bStr;
        aStr=a;
        bStr=b;
         int g = bStr.compareTo(aStr);
        return g;
        */
        return b.compareTo(a);
    }
}