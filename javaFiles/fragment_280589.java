class ClientOfX {
    X<?> member;
    void a(X<?> param) {
        param.set(param.get());
    }
    void b() {
        X<?> local = new XImpl<Object>();
        local.set(local.get());
    }
    void c() {
        member.set(member.get());
    }
    void d() {
        ClassWeCantChange.x.set(ClassWeCantChange.x.get());
    }
}

class ClassWeCantChange {
    public static X<?> x;
}