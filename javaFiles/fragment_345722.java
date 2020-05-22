public static void main(String[] args) {
    List<Object> obj = new ArrayList<>();
    String str = "ABC~DEF~GHI~JKL~~MNO";// Input String
    StringTokenizer stk = new StringTokenizer(str,"~");
    while (stk.hasMoreTokens()) {
        obj.add(stk.nextToken());
    }
    for (Object ob : obj) {
        System.out.print(ob + "~>");
    }
}