class UserFirst {

    private A a;

    @Inject
    UserFirst(@Named("first") A a) { this.a = a; }
}

class UserSecond {

    private A a;

    @Inject
    UserSecond(@Named("second") A a) { this.a = a; }
}