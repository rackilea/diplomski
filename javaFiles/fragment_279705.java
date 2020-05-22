public String toString() {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < coef.length; i++) {
        if (i != 0)
            s.append(" + ");
        s.append(coef[i]);
        s.append("x^");
        s.append(i);
    }
    return s.toString();
}