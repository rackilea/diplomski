public static void main(String[] args) {
    ArrayList<Integer> l = new ArrayList<Integer>();
    l.add(1);
    l.add(2);
    System.out.println("Non formatted: " + l);
    System.out.println(format0("" + l));
    System.out.println(format1("" + l));
    System.out.println(fmt(l)); // Short
}

static String format0(String s) {
    if(s.length() > 2)
        // Remove starting [ and ending ] from s
        return s.substring(1, s.length() - 1);
    return s;
}

static String format1(String s) {
    return s.replaceAll("[\\[\\]]","");
}

static String fmt(Object o) { return format1(o.toString()); }