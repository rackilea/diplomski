public void gotoactivity (View v) {
    calculate();
    Intent intent = new Intent(this, ResultPage.class);
    intent.putExtra("AMOUNT_3", y);
    intent.putExtra("AMOUNT_4", z);
    startActivity(intent);
}