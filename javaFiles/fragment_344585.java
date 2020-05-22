public static void main(String[] args) throws IOException {
    // TODO code application logic here

        String inputString = null; 
        String cName;
        String cCapital;
        String regionNum;
        int capitalPop;
        int region;

        File f = new File("Countries.txt"); 
        FileReader fr = new FileReader(f); 
        BufferedReader br = new BufferedReader(fr); 
        List<Country> countries = new ArrayList<Country>();
        inputString = br.readLine();    
        while (inputString != null)
        { 
            cName = inputString.substring(0, 15).trim();
            cCapital = inputString.substring(15, 30); 
            capitalPop = Integer.parseInt(inputString.substring(55, 60));
            Country country = new Country();
            country.setCName(cName);
            // set other members
            countries.add(country); // This is your list of countries
            inputString = br.readLine();    
        }
        Country[] countryArray = new Country[countries.size()];
        countries.toArray(countryArray);
        // voila.. the country array.
        br.close(); 
        fr.close(); 
}


public class Country {

 private String cName;
 private String cCapital;
 //.. other fields;


 public String getCName(){ return this.cName;}
 public void setCName(String cName) {this.cName = cName;}
 // create other setters / getters for each of the member variables.
}