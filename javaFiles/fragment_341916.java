@RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@ResponseBody
public List<Rooms> getAvailableRooms(
        @RequestParam(name = "checkin")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate checkin,
        @RequestParam(name = "checkout")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate checkout) {

        List<Rooms> rooms = yourService.getAvailableRooms(checkIn,checkOut);

    return rooms;
    }