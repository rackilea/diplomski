public class Bidder extends User{

    private String firstName, lastName, street, city, postcode, tel, eMail, cardMake, cardNo, expDate;
    private int houseNo, csvNo;

    public Bidder(){

    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public void setLastPassword(String password) {
        this.lastName = password;
    }

    // etc. for all the fields.

    public void setCSV(int csv) {
        this.csvNo = csv;
    }

    // Setters for userName, userPassword, and userType go in class User

    static ArrayList<Bidder> BidderArray = new ArrayList<Bidder>();

}