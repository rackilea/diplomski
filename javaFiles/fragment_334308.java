Optional<Double> parseDouble(String input) { 
  try {    
    return Optional.of(Double.parseDouble(input));
  } catch (Exception e) {
    return Optional.empty();
  }
}