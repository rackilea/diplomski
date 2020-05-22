public class StudentTravelCard {
    private double discount;
    private int discountCounter;
    public StudentTravelCard(int cardiD){
        super(cardiD);
        discount = 0.8;
    }
    public void newTravel() {
        if(discountCounter < 2) {
            super.newTravel();
            balance += (priceXtravel*discount);
            discountCounter ++;
        }
        else {
            super.newTravel();
        }
    }

    public void resetDay() {
        discountCounter = 0;
    }
}