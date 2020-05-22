public void run() {
    DecimalFormat df = new DecimalFormat(".##");

    secondsPassed++;
    penz += mpfiz;
    lbpenz.setText("Ennyi: "+ df.format(penz));
    txtbox1.setText("Ennyi: " + df.format(penz));
}};