public void setParkAcres(int parkAcres) {
    if (parkAcres < 0 || parkAcres > 400) {
        System.out
                .println("You have entered an invalid acre amount, it has been defaulted to 0");
        parkAcres = 0;
        return;
    }
    this.parkAcres = parkAcres;
}