DecimalFormat df = new DecimalFormat();
             df.setMinimumFractionDigits(2);
             df.setMaximumFractionDigits(2);
             df.setGroupingUsed(false);
             float a=(float) 15000.345;
             System.out.println(df.format(a));