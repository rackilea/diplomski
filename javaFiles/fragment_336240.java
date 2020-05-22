double realPrice = 10;
double total = (realPrice * 2)+1;
double increase = 0.1;

private void calculation() {

    for (double i=realPrice; i<=total; i+=increase) {

        double formula = ((realPrice*increase) + realPrice);
        increase+=0.05;
        try {
            TextView txtView = new TextView(this);
            txtView.setText(Double.toString(formula));
            ll.addView(txtView);
        } catch (Exception ignored) {}
    }
}