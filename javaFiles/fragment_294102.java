public MyCar() {
    this(new PassengerSeat());   
}

private MyCar(PassengerSeat seat) {
    super(new PassengerSeat[]{seat});   
    // Well do something with your seat now.
}