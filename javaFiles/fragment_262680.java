static final List<String> CASH_CARD = Arrays.asList("CASH", "CARD");

public List<Order> getForHotelOrders(Long hotelId, 
                                     Optional<LocalDate> fromDate, 
                                     Optional<LocalDate> toDate, 
                                     Optional<List<String>> paymentTypes) {
    List<String> paymentTypes2 = paymentTypes.orElse(CASH_CARD);
    return fromDate.isPresent() && toDate.isPresent() 
       ? orderRepository.getForHotel(hotelId, fromDate.get(), toDate.get(), paymentTypes2)
       : orderRepository.getForHotel(hotelId, paymentTypes);
}