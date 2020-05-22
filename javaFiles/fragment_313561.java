public long getXsnapped() {
    boolean isDebug = true;
    String _ = "    "; // indent
    double X = this.getX();
    Util.debugPrint(isDebug, _ + "X is %E (long bits is 0x%x)%n"
                                , X, Double.doubleToLongBits(X));
    double eps = this.getEps();
    Util.debugPrint(isDebug, _ + "eps is %E%n", eps);
    double fraction = X/eps;
    Util.debugPrint(isDebug, _ + "fraction is %E (long bits is 0x%x)%n"
                                , fraction, Double.doubleToLongBits(fraction));
    long answer = Math.round(fraction); 
    Util.debugPrint(isDebug, _ + "xSnapped is %d%n", answer);
    return answer;
}