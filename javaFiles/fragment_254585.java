public class RecordValue {
    private int _recordValue = 0;

    public int getRecordValue(){
        return _recordValue;
    }

    public void setRecordValue(int val){
        _recordValue = val;
    }
}

public class HealthTracker {
    private JFrame frame;
    private JButton btnNew;
    private JLabel lblHealthTrackerSystem;
    private JButton btnSearch;

    public JTable tblMain;
    // use an object type so we can pass it around and change the value(s)
    private RecordValue newEditAction = new RecordValue();
    //private int neweditAction;  // 0 = New, 1 = Edit
    public String servId;

    //  Public items
    //StoredProcedures sp = new StoredProcedures();
    String[] inputFlds = new String[3];
    private JButton btnDelete;

    //  Launch the application
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    HealthTracker window = new HealthTracker();
                    window.frame.setVisible(true);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    //  Create the application
    public HealthTracker() 
    {
        initialize();
    }

    //  Initialize the contents of the frame
    private void initialize()
    {
        btnNew = new JButton("Add New Record");
        btnNew.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNew.setBounds(306, 276, 125, 23);
        frame.getContentPane().add(btnNew);

        JButton btnUpdate = new JButton("Update Record");
        btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnUpdate.setBounds(576, 276, 125, 23);
        frame.getContentPane().add(btnUpdate);      

        //  Add a New Record Button        
        btnNew.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newEditAction.setRecordValue(0);// = 0; // 0 = New, 1 = Edit

                // WE ALREADY HAVE ONE. DON'T MAKE ANOTHER ONE.
                NewEditRecord nr = new NewEditRecord(newEditAction);
                nr.recordForm();
            }
        });


        //  Update a Record Button
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                servId = JOptionPane.showInputDialog(frame, "Which ServiceID Record You Want to Update?");
                newEditAction.setRecordValue(1);// = 1; // 0 = New, 1 = Edit 

                NewEditRecord ur = new NewEditRecord(newEditAction);
                ur.recordForm();
            }
        });
    }

    public int getNewEditAction() 
    {
        System.out.println("getNewEditAction = " + this.newEditAction.getRecordValue());
        return this.newEditAction.getRecordValue();
    }
}

public class NewEditRecord {
    private JFrame frame;

    // we don't need an entire tracker to do anything in here
    //HealthTracker ht = new HealthTracker();
    RecordValue _recordValue;
    //int recAction = ht.getNewEditAction();

    //  Launch the application
    // there is no reason for this to be static
    public /*static*/ void recordForm() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {                   
                    // don't make ANOTHER instance, we're in one already!!!!!!
                    //NewEditRecord window = new NewEditRecord();
                    /*window.*/frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //  Create the application
    public NewEditRecord(RecordValue recordValue) {
        _recordValue = recordValue;
        initialize();
    }

    //  Initialize contents of frame
    private void initialize() {
//        frame = new JFrame();
//        frame.setBounds(100, 100, 706, 390);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().setLayout(null);
//
//        txtInstitution = new JTextField();
//        txtInstitution.setBounds(100, 47, 540, 20);
//        lblInstitution.setLabelFor(txtInstitution);
//        frame.getContentPane().add(txtInstitution);
//        txtInstitution.setColumns(10);
//
//        //  If Updating, Load Fields w/Record Data      
//        if (recAction == 1){
//            String qry = "SELECT ServiceID, Institution, Doctor, CONCAT(Street,', ',City, ', ', State, ' ', ZipCode) AS Address, Date, Cost"
//                        + ", Caption AS ServiceType, Comments FROM Services s INNER JOIN ServiceTypes st ON s.ServiceTypeID = st.ServiceTypeID"
//                        + " WHERE (ServiceID = '"+ recServID + "')";
//
//            try{
//                Connection dbconn = StoredProcedures.dbConn();
//                Statement stmt = dbconn.createStatement();
//                ResultSet rs = stmt.executeQuery(qry);
//
//                while (rs != null && rs.next()){
//                    txtInstitution.setText(rs.getString("ServiceID"));
//                }   
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }           
//        }
//
//        //  Close Form
//        btnCancel.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
//                frame.dispose();
//            }
//        });
    }
}