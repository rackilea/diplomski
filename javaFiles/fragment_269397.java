public Money (int dol, int cent) {
    dol = this.dollars;
    cent = this.cents;
    if (dol < 0 || cent < 0) {
        throw new IllegalArgumentException ("Must be greater than 0.");
    }
}