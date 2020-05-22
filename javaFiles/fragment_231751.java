enum Mammals {
    DOG(),
    CAT();

    public String alias;

    Mammals() {
        this.alias = name().toLowerCase();
        System.out.println(alias);
    }
}