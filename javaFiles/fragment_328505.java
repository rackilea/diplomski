public class PersonalInfo extends JFrame
{
    public PersonalInfo() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblPersonalInfo = new JLabel("Personal Information");
        lblPersonalInfo.setFont(new Font("Arial", Font.BOLD, 16));
        lblPersonalInfo.setBounds(110, 11, 185, 14);
        panel.add(lblPersonalInfo);

        JLabel lblFullName = new JLabel("Full Name");
        lblFullName.setBounds(10, 36, 58, 14);
        panel.add(lblFullName);

        JLabel lblNationality = new JLabel("Nationality");
        lblNationality.setBounds(10, 61, 78, 14);
        panel.add(lblNationality);

        JLabel lblDateBirth = new JLabel("Date of Birth");
        lblDateBirth.setBounds(10, 86, 78, 14);
        panel.add(lblDateBirth);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(10, 111, 46, 14);
        panel.add(lblGender);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(10, 164, 58, 14);
        panel.add(lblAddress);

        JLabel lblMobile = new JLabel("Mobile");
        lblMobile.setBounds(10, 189, 46, 14);
        panel.add(lblMobile);

        JLabel lblEmail = new JLabel("E-mail");
        lblEmail.setBounds(10, 214, 46, 14);
        panel.add(lblEmail);

        JRadioButton rdbtnM_2 = new JRadioButton("M");
        rdbtnM_2.setBounds(74, 133, 109, 23);
        panel.add(rdbtnM_2);

        JRadioButton rdbtnF = new JRadioButton("F");
        rdbtnF.setBounds(74, 107, 109, 23);
        panel.add(rdbtnF);
       }
     }