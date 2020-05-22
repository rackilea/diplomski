public class Main {

public static void main(String[] args) {
    Room office = new Room(17, 0, 10);
    Room lecture = new Room(2, 0, 10);
    Room lab = new Room(18, 1, 1);

    System.out.println(office);  // => "17-0.10"
    System.out.println(lecture); // => " 2-0.10"
    System.out.println(lab);     // => "18-1.01"
}
}