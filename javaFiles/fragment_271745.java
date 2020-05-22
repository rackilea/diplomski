static class PositionInfo {
    public final double latitude;
    public final double longitude;
    public final int ageMs;
    public final int strength;

    public PositionInfo(double latitude, double longitude, int ageMs, int strength) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.ageMs = ageMs;
        this.strength = strength;
    }

    public double getWeight() {
        return Math.min(1.0, Math.sqrt(2000.0 / ageMs)) / (strength * strength);
    }
}


static DerivativeStructure getWeightedEuclideanDistance(double tgtLat, double tgtLong, PositionInfo knownPos) {
    DerivativeStructure varLat = new DerivativeStructure(2, 1, 0, tgtLat); // latitude is 0-th variable of 2 for derivatives up to 1
    DerivativeStructure varLong = new DerivativeStructure(2, 1, 1, tgtLong); // longitude is 1-st variable of 2 for derivatives up to 1
    DerivativeStructure latDif = varLat.subtract(knownPos.latitude);
    DerivativeStructure longDif = varLong.subtract(knownPos.longitude);
    DerivativeStructure latDif2 = latDif.pow(2);
    DerivativeStructure longDif2 = longDif.pow(2);
    DerivativeStructure dist2 = latDif2.add(longDif2);
    DerivativeStructure dist = dist2.sqrt();
    return dist.multiply(knownPos.getWeight());
}

// as in https://en.wikipedia.org/wiki/Haversine_formula
static DerivativeStructure getWeightedHaversineDistance(double tgtLat, double tgtLong, PositionInfo knownPos) {
    DerivativeStructure varLat = new DerivativeStructure(2, 1, 0, tgtLat);
    DerivativeStructure varLong = new DerivativeStructure(2, 1, 1, tgtLong);
    DerivativeStructure varLatRad = varLat.toRadians();
    DerivativeStructure varLongRad = varLong.toRadians();
    DerivativeStructure latDifRad2 = varLat.subtract(knownPos.latitude).toRadians().divide(2);
    DerivativeStructure longDifRad2 = varLong.subtract(knownPos.longitude).toRadians().divide(2);
    DerivativeStructure sinLat2 = latDifRad2.sin().pow(2);
    DerivativeStructure sinLong2 = longDifRad2.sin().pow(2);
    DerivativeStructure summand2 = varLatRad.cos().multiply(varLongRad.cos()).multiply(sinLong2);
    DerivativeStructure sum = sinLat2.add(summand2);
    DerivativeStructure dist = sum.sqrt().asin();
    return dist.multiply(knownPos.getWeight());
}