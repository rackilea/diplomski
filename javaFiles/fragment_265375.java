NumberFormat format = NumberFormat.getNumberInstance(Locale.GERMAN);
    format.setMinimumFractionDigits(2);
    format.setMaximumFractionDigits(2);
    double price = <your price>;
    int priceAsInt = (int)price;
    if(((double)priceAsInt) == price) {
        String number = String.valueOf(priceAsInt);
        System.out.println(number);
    } else {
        String number = format.format(price);
        System.out.println(number);
    }