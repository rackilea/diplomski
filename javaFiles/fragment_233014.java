public class Table {

    public ArrayList<Row> applicants;

    public String appArray[];

    /**
     * Constructor for objects of class Table
     */
    public Table() {
    applicants = new ArrayList<String>();
    }

    public void addApplicant(Row app) {
    applicants.add(app);

    }


    public void list() // Lists the arrayList
    {
    for(int i = 0; i < applicants.size(); i++) {
        Row row = (Row) applicants.get(i);  
        System.out.println("Applicant ID: "+ row.getApplicantID() +
        "  Applicant Name: " + row.getApplicantName());
    }
    }

}