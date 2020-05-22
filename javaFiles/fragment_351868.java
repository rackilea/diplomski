Map<String, BigDecimal> counts = new HashMap<>();

counts.merge("sugar", BigDecimal.valueOf(2.3), BigDecimal::add);
counts.merge("salt", BigDecimal.valueOf(4.5), BigDecimal::add);
counts.merge("pepper", BigDecimal.valueOf(1.8), BigDecimal::add);
counts.merge("sugar", BigDecimal.valueOf(1.4), BigDecimal::add);

System.out.println(counts); // {pepper=1.8, salt=4.5, sugar=3.7}