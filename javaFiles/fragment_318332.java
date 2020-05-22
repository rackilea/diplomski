class Me {
    private Me() {};

    private static Me *loner = NULL;

    public static synchronised Me *getMe() {
        if loner == NULL
            loner = new Me();
        return loner;
    }
}