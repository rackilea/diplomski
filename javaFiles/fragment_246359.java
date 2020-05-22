public class YourAction exteds ActionSupport{

    private List<String> mails = new ArrayList<String>();
    /* put Getter and Setter for mails here */

    public String execute(){

        /* ... other stuff here ... */    

        ResultSet r = st.executeQuery("select unique(emailid) from pagequery");
        while (r.next()) {
            mails.add(r.getString(1));
        }
        return SUCCESS;
    }
}