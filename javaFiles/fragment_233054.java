public class TicketGenie {

    private JPanel panel;
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