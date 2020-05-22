public class Main {

    public static void main(String[] args) {
    //code for GUI not included but pretend the GUI is called here
    // Assuming something like:
    GUI gui = new GUI();

    Configuration conf = gui.getConfig();

    System.out.println("Data from GUI: [season]"+ conf.getSeason()+ " Season expectations: " + conf.expectations());
    }
}