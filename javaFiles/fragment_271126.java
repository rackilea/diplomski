if (status == Status.AIRCRAFT_CARRIER_HIT) {
    if (this.getFleet().updateFleet(ShipType.ST_AIRCRAFT_CARRIER)) {
        result[1] = "a";
    }
} else if (status == Status.BATTLESHIP_HIT) {
    // etc.
} else {
    result[1] = null;
}