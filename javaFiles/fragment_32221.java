private static double getSubstraction(double summ, String your) {
    if (your.contains("-")) {
        return summ + Double.parseDouble(your.replace("-", ""));
    } else if (your.contains("+")) {
        return summ - Double.parseDouble(your.replace("+", ""));
    } else {
        return summ  - Double.parseDouble(your);
    }

}

private static double getSumm(double sub, String your) {
    if (your.contains("-")) {
        return sub - Double.parseDouble(your.replace("-", ""));
    } else if (your.contains("+")) {
        return sub  + Double.parseDouble(your.replace("+", ""));
    } else {
        return sub + Double.parseDouble(your);
    }
}