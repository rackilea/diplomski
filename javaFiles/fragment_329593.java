public SpaceShip {
    private double oilLevelInLitres;
    private String model;

    public SpaceShip(double oilLevelInLitres, String model) {
       this.oilLevelInLitres = oilLevelInLitres;
       displayOilLevel();
       this.model = model;
    }

    public void displayOilLevel() {
       System.out.println("Oil level is currently " + oilLevelInLitres + " litres");
    }
}

public SpaceShipWithSecondaryReservoir {    
    public SpaceShip(double oilLevelInLitres, double secondaryReservoirOilLevelInLitres, String oilLevelInLitres) {
        super(oilLevelInLitres, oilLevelInLitres);
        this.secondaryReservoirOilLevelInLitres = secondaryReservoirOilLevelInLitres;
    }

    public void displayOilLevel() {
        System.out.println("Model " + model + " oil level is currently " + oilLevelInLitres + 
            " litres and " + secondaryReservoirOilLevelInLitres + " litres in the seconday reservoir");
    }
}

public Main() {
    public static void main(String[] args) {
        // will print "Model null oil level is currently 17.0 litres and 5.0 litres in 
        // the secondary reservoir"
        new SpaceShipWithSecondaryReservoir(17, 5, "Falcon-3X"); 
    }
}