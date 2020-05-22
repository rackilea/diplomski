Map extmap = new HashMap();

  @Autowired
  OmegaContext omegaContext;

  @Compensable(compensationMethod = "cancel")
  void order(CarBooking booking) {
    booking.confirm();
    bookings.put(booking.getId(), booking);

    //save flag 
    extmap.put(omegaContext.localTxId(),'Your flag') 
  }

  void cancel(CarBooking booking) {
    //get flag
    extmap.get(omegaContext.localTxId());

    Integer id = booking.getId();
    if (bookings.containsKey(id)) {
      bookings.get(id).cancel();
    }
  }