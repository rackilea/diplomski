public Money (int dol, int cent) {
    this.dollars = dol;
    this.cents = cent;
    if (dol < 0 || cent < 0) {
        throw new IllegalArgumentException ("Must be greater than 0.");
    }
}