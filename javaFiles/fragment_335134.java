public class Dude{
    public String fName;
    public String lName;

    public String getFName() {
        return fName;        
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getFullName() {
        return this.fName + " " + this.lName;
    }
}