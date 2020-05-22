private int personalLoan;
private int donationGifts;
private int recreation;
private int houseHoldItems;
...

@Override
public void setPersonalLoan(int budget) {
    this.personalLoan = budget;
}
@Override
public void setDonationsGifts(int budget) {
    this.donationGifts = budget;
}
@Override
public void setRecreation(int budget) {
    this.recreation = budget;
}
@Override
public void setHouseHoldItems(int budget) {
    this.houseHoldItems = budget;
}
...


public double getTotal() {
    double total = personalLoan + donationGifts + recreation + houseHoldItems + utilities + savings + groceries....
    return total;
}