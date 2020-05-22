@Override
public double getPrice() {
    double sum = 0;
    double discount = (rabatt / 100);

    for(Item element : allOrders) {
        sum += element.getPrice();         
    }

    return sum - (sum * discount);
}