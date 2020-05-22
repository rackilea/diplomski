Pattern complexNumberPattern = Pattern.compile(
    "\\(\\s*" +         // opening parenthesis
    "(-?[0-9.]+)" +     // group 1: match real part
    "\\s*([-+])\\s*" +  // group 2: match sign
    "([0-9.]+)j" +      // group 3: match imaginary part
    "\\s*\\)");         // closing parenthesis
Matcher matcher = complexNumberPattern.matcher("");

JsonArray data = jsonObject.getJsonArray("data");
int count = data.size();

List<List<Complex>> allFrequencyValues = new ArrayList<>(count);

for (int i = 0; i < count; i++) {

    String complexValuesStr = data.getString(i);

    List<Complex> singleFrequencyValues = new ArrayList<>();

    matcher.reset(complexValuesStr);
    while (matcher.find()) {
        double real = Double.parseDouble(matcher.group(1));
        boolean positive = matcher.group(2).equals("+");
        double imaginary = Double.parseDouble(matcher.group(3));

        Complex value = new Complex(real, positive ? imaginary : -imaginary);
        singleFrequencyValues.add(value);
    }

    allFrequencyValues.add(singleFrequencyValues);
}