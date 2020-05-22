public enum Role {

    ADMIN("SMITH","KEVIN"),
    STUDENT("JACK", "JILL", "MARRY", "MALA"),
    GURDIAN("BOB");

    private Role(String...name) {
        this.values = name;
    }
}