if (i == j) {
    int n = Integer.parseInt(System.getProperty("breakpoint.n", "0"));
    n++;
    System.setProperty("breakpoint.n", "" + n);
    if (n > 400) return true;
}
return false;