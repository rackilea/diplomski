public class Kettle extends WaterHeater {

    public Kettle(double water, double kilowatts, double joules, double temp, double jkg) {
        super(water, kilowatts, joules, temp, jkg);     
    }

    public static void main(String args[]) {

        WaterHeater kettle = new WaterHeater(1, 2, 3600, 70, 4200);

        System.out.println("\nWater: " + kettle.getWater() + " L" + "\nKilowatts: " + kettle.getKilowatts() + " KW" + "\nEnergy used: " + kettle.getEnergy() + " J"
            + "\nTime to boil: " + kettle.getTime() + " Seconds");
    }
}