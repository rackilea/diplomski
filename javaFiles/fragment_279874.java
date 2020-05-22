public class Application {

        private Scanner scan;
        private Admin admin;
        private ZoneCost zoneCost;
        private Attendants attendants;
        private Database database;

        private Application() {
            scan = new Scanner(System.in);
            zoneCost = new ZoneCost();
            attendants = new Attendants();
            database = new Database();
            zoneCost.load();
            database.load();
            admin = new Admin(scan, zoneCost, database, attendants );
        }



    public class Admin {

        private Scanner scan;
        private Attendants attendant;
        private ZoneCost zoneCost;
        private Database database;

        Admin(Scanner scan, ZoneCost zoneCost, Database database, 
              Attendants attendant) {
            this.scan = scan;
            this.attendant = attendant;
            this.zoneCost = zoneCost;
            this.database = database;
        }