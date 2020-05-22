public class RetrieveEvNaCoNaAction extends ActionSupport {

    private static final long serialVersionUID = -5418233715172672477L;

    @Getter         private List<Event>     dataForBillsJspList     = new ArrayList<Event>();

    @Getter         private List<String>    events                  = new ArrayList<String>();
    @Getter         private List<String>    companies               = new ArrayList<String>();

    @Getter @Setter private String          event                   = null;
    @Getter @Setter private String          company                 = null;




    @Override
    public void prepare() throws Exception {        
        Connection con;
        try {           
            con = new Database().Get_Connection();

            // load companies
            PreparedStatement ps = con.prepareStatement("SELECT DISTINCT company_name FROM event");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { companies.add(rs.getString("company_name")); }

            // load events
            ps = con.prepareStatement("SELECT DISTINCT event_name FROM event");
            rs = ps.executeQuery();
            while (rs.next()) { events.add(rs.getString("event_name")); }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
    }

    @Override
    public String execute() {
        Connection con;
        try {           
            con = new Database().Get_Connection();

            // load the table. The first time the table is loaded completely
            String sql = "SELECT EVENT_ID, EVENT_NAME, COMPANY_NAME, CONTACT_PERSON, CONTACT_NO, EMAIL_ID, EVENT_VENUE, " + 
                         "date_format(FROM_DATE,'%d/%m/%Y') as dateAsFrom, date_format(TO_DATE,'%d/%m/%Y') as dateAsTo ,EVENT_TIME " + 
                         "FROM event";
            String where = "";

            // if instead this action has been called from the JSP page, 
            // the result is filtered on event and company:
            if (event!=null && company!=null) { 
                where = " WHERE event_name = ? AND company_name = ?"; 
            }

            // load companies
            PreparedStatement ps = con.prepareStatement(sql + where);
            if (where.length()>0) { 
                ps.setString(1,event); 
                ps.setString(2,company); 
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { 
                dataForBillsJspList.add(new Event(rs.getString("EVENT_ID"),rs.getString("EVENT_NAME"),rs.getString("COMPANY_NAME"),
                                                  rs.getString("CONTACT_PERSON"),rs.getString("CONTACT_NO"),rs.getString("EMAIL_ID"),
                                                  rs.getString("EVENT_VENUE"), rs.getString("dateAsFrom"), rs.getString("dateAsTo"),
                                                  rs.getString("EVENT_TIME")));
            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
        }

        return SUCCESS;
    }

}