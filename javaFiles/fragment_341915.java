@RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@ResponseBody
public ReservationResponse getAvailableRooms(
        @RequestParam(name = "checkin")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate checkin,
        @RequestParam(name = "checkout")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate checkout) {
        ReservationResponse> reservationResponse = new ReservationResponse();
        List<Rooms> rooms = yourService.getAvailableRooms(checkIn,checkOut);
        reservationResponse.setAvailableRooms(rooms);
    return reservationResponse;
    }