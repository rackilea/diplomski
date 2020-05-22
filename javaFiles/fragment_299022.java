private void calculate(){
    total = 0;

    for (Order orders: listData){
        total += Integer.parseInt(orders.getPrice()) * Integer.parseInt(orders.getQuantity());
        Log.d("GDGDGD", String.valueOf(total));
    }
    int cgst = (total * 5)/100;
    total += cgst;
    Locale locale = new Locale("en","IN");
    NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
    cartActivity.txtTotalPrice.setText(fmt.format(total));
}