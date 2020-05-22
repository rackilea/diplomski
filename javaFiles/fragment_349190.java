public @interface Funky {
    Monkey monkey();
}
public @interface Monkey {
    Funky funky();
}