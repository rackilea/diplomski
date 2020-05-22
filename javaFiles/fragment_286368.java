public double parseDouble(String doubleText) {
if (TextUtils.isEmpty(doubleText)) {
    return 0.00;
}

try {
    return Double.parseDouble(doubleText);
} catch (NumberFormatException e) {
    // do something if invalid number maybe also return 0?
    return 0.00;
}
}