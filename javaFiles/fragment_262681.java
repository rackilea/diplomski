public List<Order> getForHotelOrders(long hotelId, 
                                     Optional<LocalDate> fromDate, 
                                     Optional<LocalDate> toDate, 
                                     Optional<List<String>> paymentTypes) {
    return orderRepository.getForHotel(hotelId, 
                                       fromDate.orElse(LocalDate.MIN),
                                       toDate.orElse(LocalDate.MAX),
                                       paymentTypes.orElse(CASH_CARD));
}