private String evaluate(String code) {  
      return evaluators.stream()
          .map(f -> f.apply(code))
          .filter(s -> s != null)
          .findFirst().get();
  }