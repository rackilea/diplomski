class Flight {
    private String departures;
    private String arrival;
    private int price;
    private int flightNum;

    public Flight(String departures, String arrival, int price, int flightNum){
        this.departures = departures;
        this.arrival = arrival;
        this.price = price;
        this.flightNum = flightNum;
    }
    public String getParameters(){
        return "Lot z "+this.departures+" do "+this.arrival+" kosztuje "+this.price;
   }
    public String getDepartures() {
        return departures;
    }
    public String getArrival() {
        return arrival;
    }
    public int getPrice() {
        return price;
    }
    public int getFlightNum() {
        return flightNum;
    }
    public void setDepartures(String departures) {
        this.departures = departures;
    }
    public void setArrival(String arrival) {
        this.arrival = arrival;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setFlightNum(int flightNum) {
        this.flightNum = flightNum;
    }

}