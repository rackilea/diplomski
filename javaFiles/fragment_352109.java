public class Main {
public static void main(String[] args) {
Wall wall1 = new Wall("West");
Wall wall2 = new Wall("East");
Wall wall3 = new Wall("South");
Wall wall4 = new Wall("North");

Ceiling ceiling = new Ceiling(12, 55);

Bed bed = new Bed("Modern", 4, 3, 2, 1);

Lamp lamp = new Lamp("classic", false, 75);

BedRoom bedroom = new BedRoom("test",wall1,wall2,wall3,wall4,ceiling,bed,lamp);

bedroom.makeBed(); //bedroom.makeBed(); does not work 
//It does not show the public method "makeBed" in the BedRoom class
}
}