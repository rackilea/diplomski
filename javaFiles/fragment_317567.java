//use a max value for comparisons
private static final String MAX_STRING = String.valueOf(Character.MAX_VALUE); 

public static void compareMe(String a, String b, String c, String d, String e) {
    if (a.compareTo(b) <= 0) {
        if (a.compareTo(c) <= 0) {
            if (a.compareTo(d) <= 0) {
                if (a.compareTo(e) <= 0) {
                    if (a != MAX_STRING) {
                        System.out.println(a);
                        a = MAX_STRING;
                    } else {
                        return;
                    }
                }
                //swap (a,e)
                compareMe(e, b, c, d, a);
            } else {
                //swap (a,d)
                compareMe(d, b, c, a, e);
            }
        } else {
            //swap (a,c)
            compareMe(c, b, a, d, e);
        }
    } else {
        //swap (a,b)
        compareMe(b, a, c, d, e);
    }
}