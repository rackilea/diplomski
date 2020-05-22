private static boolean isInvalidCharacter(char c, boolean newlineIllegal, boolean tabIllegal) {
    if (c == 0x7F) return true;
    if (c == 0xA) return newlineIllegal;
    if (c == 0x9) return tabIllegal;
    if (c < 0x20) return true;
    return false;
}