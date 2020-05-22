NavigableMap<Double, Double> payToTaxRate = new TreeMap<Double, Double>();

// e.g., loaded from a file:
payToTaxRate.put(100000, 0.4);
payToTaxRate.put(60000, 0.3);
payToTaxRate.put(30000, 0.2);
payToTaxRate.put(15000, 0.1);
payToTaxRate.put(5000, 0.05);
payToTaxRate.put(Double.MIN_VALUE, 0);

System.out.prinln(pay * payToTaxRate.floorEntry(pay).getValue());