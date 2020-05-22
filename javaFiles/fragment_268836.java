public double calculateBSA(double height, double grams) {
    double weightforBmi = convertGramsToPounds(grams);
    return  Math.sqrt(((convertCentimeterToInches(height) * weightforBmi) / 3131));
}

private double convertCentimeterToInches(double height) {
    return (height / 2.54);
}

public double convertGramsToPounds(double grams) {
    double gramsToPoundUnit = .00220462262;
    double pounds = (grams * gramsToPoundUnit);
    return pounds;
}