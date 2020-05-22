BigDecimal pp1 = pp.setScale(2, RoundingMode.HALF_EVEN);
    System.out.println("HALF_EVEN: "+pp1.toString());
    BigDecimal pp2 = pp.setScale(2,RoundingMode.FLOOR);
    System.out.println("FLOOR: "+pp2.toString());
    BigDecimal pp3 = pp.setScale(2,RoundingMode.CEILING);
    System.out.println("CEILING: "+pp3.toString());