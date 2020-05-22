String input = ...;
Optional<Double> parsedInput = parseDouble(input);
if (! parsedInput.isPresent()) {
    // print out warning and retry input or whatever
}
double convertedInput = parsedInput.value();