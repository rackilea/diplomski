BigDecimal bg1 = new BigDecimal("56565656.342");
        BigDecimal bg2 = new BigDecimal("56565656.00");
        BigDecimal bg3 = new BigDecimal("56565656.70");

        DecimalFormat df = new DecimalFormat("###,###.00");
        System.out.println(df.format(bg1.doubleValue()));
        System.out.println(df.format(bg2.doubleValue()));
        System.out.println(df.format(bg3.doubleValue()));

        System.out.println(bg1.setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bg2.setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bg3.setScale(2, BigDecimal.ROUND_HALF_UP));