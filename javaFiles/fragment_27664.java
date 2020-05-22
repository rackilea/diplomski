private static Map<String,Double> frequencyFactor = new HashMap<>();
frequencyFactor.add("Monthly", 1);
frequencyFactor.add("Annualy", 1.0/12);
frequencyFactor.add("Yearly", 1.0/12);
frequencyFactor.add("Quaterly", 1.0/4);
frequencyFactor.add("Semiannually", 1.0/6);

Integer sum = subs.stream()
                  .mapToDouble(sub -> sub.getAmount() * frequencyFactor.get(sub.getFrequency()))
                  .sum();