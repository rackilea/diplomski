BigDecimal i = new BigDecimal(0.025);
    int n = 2;
    BigDecimal h1 = new BigDecimal(2000);
    BigDecimal h2 = new BigDecimal(4000);

    BigDecimal y1 = ((BigDecimal.ONE.add(i)).pow(n)).multiply(h1);
    BigDecimal y2 = ((BigDecimal.ONE.add(i)).pow(n)).multiply(h2);
    BigDecimal result =  y1.add(y2);

    System.out.println(result.toEngineeringString());