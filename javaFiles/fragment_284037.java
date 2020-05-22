for(Fee fee : fees){
    if(fee.getId.equals(id)){
        if(fee.getFromdate().isBefore(LocalDateTime.now())){
            if(fee.getTodate().isAfter(LocalDateTime.now())){
                BigDecimal z = new BigDecimal(fee.getFundservicefee());
                return z.movePointLeft(2);
            }
        }
      }
  }