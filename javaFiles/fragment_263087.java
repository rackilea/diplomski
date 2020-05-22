public static class MyType {
    private Object member;

    public MyType(Object o, Object o2, Object o3) {
        Object t = o;
        member = o2;
        System.out.println(t.getClass());
        System.out.println(member.getClass());
        member = o3;
        System.out.println(member.getClass());
    }
}