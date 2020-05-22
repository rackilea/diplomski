public static void main(String... a){
    if(a.length<1){
        System.err.println("The first argument is the price of the item.");
        return;
    }
    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
    final double PRICE=Double.parseDouble(a[0]);
    double remaining=PRICE;
    while(remaining>0){         
        String input = System.console().readLine(currency.format(remaining) + " remains to be paid. Enter coin or note: ");
        Double x=null;
        try {
            x = currency.parse(input).doubleValue();
        } catch (ParseException e) {
            System.out.println("Invalid coin or note. Try again.");
        }
        if(x!=null) remaining-=x;
    }
    if(remaining!=0)
        System.out.println("You gave " + currency.format(PRICE - remaining) + ", your change is " + currency.format(-remaining));
}