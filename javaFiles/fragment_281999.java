public Button getButton(PersonSalutations s) {
    if (s == PersonSalutations.MR)
        return this.mr;
    if (s == PersonSalutations.MS)
        return this.ms;
    throw new IllegalArgumentException("Invalid: " + s);
}