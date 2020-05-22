public XVar getVar(String varName) {
    for (int i = 0; i < varCount; i++) {
        if (xvars[i].name == varName) {
            return xvars[i];
        }
    }

    return null;
}