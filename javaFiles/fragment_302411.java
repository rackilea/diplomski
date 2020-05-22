public static int parsuj(String argz) throws Zakres,NieprawidlowaDana {
    for (int i = 0; i < argz.length(); i++) {
        if (argz.charAt(i) == '-')
            throw new Zakres();
        if (!Character.isDigit(argz.charAt(i)))
            throw new NieprawidlowaDana();
    }
    return Integer.parseInt(argz);
}