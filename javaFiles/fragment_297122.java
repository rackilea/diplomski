BigDecimal bd = new BigDecimal("4893.305785123966785163027491292661448576748");
    bd = bd.setScale(3, BigDecimal.ROUND_DOWN);       // truncate to 4893.305
    bd = bd.setScale(2, BigDecimal.ROUND_HALF_DOWN);  // round to 2 decimal places
    System.out.println(bd);                           // 4893.30

    bd = new BigDecimal("4893.306785123966785163027491292661448576748");
    bd = bd.setScale(3, BigDecimal.ROUND_DOWN);       // truncate to 4893.306
    bd = bd.setScale(2, BigDecimal.ROUND_HALF_DOWN);  // round to 2 decimal places
    System.out.println(bd);                           // 4893.31