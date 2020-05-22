int currencyCode = SharedPrefManager.getInstance(MainActivity.this).getUser().getCurrency();
if (currencyCode == 1) {
    creditnav.setText("USD");
}
if (currencyCode == 3) {
    creditnav.setText("GHS");
}