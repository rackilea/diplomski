public class TicketGenie {

    //Initialized and declared static JPanel Container 
    static JPanel panel=new JPanel();

    //Components declared
    private JTextField firstname;
    private JTextField lastname;
    private JTextField address;
    private JTextField city;
    private JTextField state;
    private JTextField zipcode;
    private JTextField phonenumber;
    private JTextField email;
    private JTextField numberoftickets;
    private JButton submitButton;
    private JLabel firstnamelbl;
    private JLabel lastnamelbl;
    private JLabel addresslbl;
    private JLabel citylbl;
    private JLabel statelbl;
    private JLabel zipcodelbl;
    private JLabel phonenumberlbl;
    private JLabel emaillbl;
    private JLabel ticketlbl;

    public TicketGenie() {

    //Components initialized
    firstname=new JTextField();
    lastname=new JTextField();
    address=new JTextField();
    city=new JTextField();
    state=new JTextField();
    zipcode=new JTextField();
    phonenumber=new JTextField();
    email=new JTextField();
    numberoftickets=new JTextField();
    submitButton=new JButton();
    firstnamelbl=new JLabel();
    lastnamelbl=new JLabel();
    addresslbl=new JLabel();
    citylbl=new JLabel();
    statelbl=new JLabel();
    zipcodelbl=new JLabel();
    phonenumberlbl=new JLabel();
    emaillbl=new JLabel();
    ticketlbl=new JLabel();

        //Add Components to JPanel Container 
        panel.add(firstname);
        panel.add(lastname);
        panel.add(address);
        panel.add(city);
        panel.add(state);
        panel.add(zipcode);
        panel.add(phonenumber);
        panel.add(email);
        panel.add(numberoftickets);

        panel.add(firstnamelbl);
        panel.add(lastnamelbl);
        panel.add(addresslbl);
        panel.add(citylbl);
        panel.add(statelbl);
        panel.add(zipcodelbl);
        panel.add(phonenumberlbl);
        panel.add(emaillbl);
        panel.add(ticketlbl);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
 }