BigDecimal value1 = new BigDecimal("11.4443999999999999062083588796667754650115966796875");      
BigDecimal value2 = new BigDecimal("35.9549999999999982946974341757595539093017578125"); 

BigDecimal rounded1 = value1.setScale(3, RoundingMode.HALF_UP); // 11.444
rounded1 = rounded1.setScale(2, RoundingMode.HALF_UP);          // 11.44

BigDecimal rounded2 = value2.setScale(3, RoundingMode.HALF_UP); // 35.955
rounded2 = rounded2.setScale(2, RoundingMode.HALF_UP);          // 35.96