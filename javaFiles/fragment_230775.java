public int prefixLength(String path) {
    char slash = this.slash;
    int n = path.length();
    if (n == 0) return 0;
    char c0 = path.charAt(0);
    char c1 = (n > 1) ? path.charAt(1) : 0;
    if (c0 == slash) {
        if (c1 == slash) return 2;  /* Absolute UNC pathname "\\\\foo" */
        return 1;                   /* Drive-relative "\\foo" */
    }
    if (isLetter(c0) && (c1 == ':')) {
        if ((n > 2) && (path.charAt(2) == slash))
            return 3;               /* Absolute local pathname "z:\\foo" */
        return 2;                   /* Directory-relative "z:foo" */
    }
    return 0;                       /* Completely relative */
}