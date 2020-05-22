Comparator<BO> comparator = Comparator
    .<BO, BigDecimal>comparing( (bo) -> maxGroup.get( bo.getCcy() ) ).reversed() //first compare by max cash in desc order
    .thenComparing(BO::getCcy) //then by currency
    .thenComparing( Comparator.comparing(BO::getCash).reversed() ); //and finally by cash in desc order

    Collections.sort( boList, comparator);