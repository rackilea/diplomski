public class verbindung { 

     public static void main(String[] args) {
        String filename = "betreuen_4.csv";
        File file = new File(filename);

        ArrayList<caring> betreuen = new ArrayList<caring>();

        try {
            Scanner inputStream = new Scanner(file);
            while(inputStream.hasNext()) {
                String data = inputStream.next();
                String[] values = data.split(",");
                int PInummer = Integer.parseInt(values[1]);
                String MNummer = values[0];
                String KundenID = values[2];
                System.out.println(MNummer);
                //create the caring object with the required paramaters
                caring _caring = new caring(MNummer, PInummer, KundenID);
                //add _caring object to the betreuen array here as it is within the same scope.
                betreuen.add(_caring);
            }
            inputStream.close();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        //this will cause a compilation error
        //betreuen[0] = MNummer;

        //this will also cause a compilation error because it is out of the scope of _caring
        //betreuen.add(_caring);
    }
}