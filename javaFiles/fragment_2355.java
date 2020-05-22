String money = "$1,234,000.67";
    try {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        Number number = format.parse(money);
        System.out.println(number.doubleValue());
    } catch (ParseException e) {
        e.printStackTrace();
    }