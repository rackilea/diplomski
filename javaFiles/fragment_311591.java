public Console console() {
    if (istty()) {
        if (cons == null)
            cons = new Console();
            return cons;
        }
    return null;
}