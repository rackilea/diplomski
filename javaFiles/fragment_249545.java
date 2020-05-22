// Parse strings.
    LocalDate date = LocalDate.parse ( dateInput );
    LocalTime time = LocalTime.parse ( timeInput );
    Integer price = Integer.parseInt ( priceInput );
    // Combine date and time.
    LocalDateTime ldt = LocalDateTime.of ( date , time );  // Not a specific moment on the timeline.