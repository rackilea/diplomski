Optional<Double> parseDouble(String input, double defaultValue) { 
  if (input == null || input.trim().length == 0) {
    return Optional.of(defaultValue);
  }
  try {    
    return Optional.of(Double.parseDouble(input));
  } catch (NumberFormatException e) {
    return Optional.empty();
  }
}