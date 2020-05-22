public class RegisterStart extends JFrame {

    private JPanel contentPane;
    private static JTextField uid, fname, lname, sa;
    private static JPasswordField pass;
    private static JComboBox sq;

    private static Connection Conn;
    private static ResultSet Rs;
    static Properties prop = new Properties();
    static InputStream input = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try 
                {
                    RegisterStart frame = new RegisterStart();
                    frame.setVisible(true);
                    Randomize();

                    input = new FileInputStream("/Users/rajat/Programming/EclipseJava/Student Manager/src/config.properties");
                    prop.load(input);

                    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                    Conn = DriverManager.getConnection(prop.getProperty("database"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
                    Randomize();
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        });
    }


    public RegisterStart() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 440);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 204, 153));
        contentPane.setBorder(null);
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(20, 0, 0, 0));
        panel.setBackground(new Color(255, 204, 153));
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel lblAdminRegistration = new JLabel("ADMIN REGISTRATION");
        lblAdminRegistration.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblAdminRegistration.setBackground(new Color(255, 204, 153));
        panel.add(lblAdminRegistration);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 204, 153));
        contentPane.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("USER ID                          :");
        lblNewLabel.setBounds(62, 45, 180, 16);
        panel_1.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("FIRST NAME                    :");
        lblNewLabel_1.setBounds(62, 83, 180, 16);
        panel_1.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("LAST NAME                     :");
        lblNewLabel_2.setBounds(62, 122, 180, 16);
        panel_1.add(lblNewLabel_2);

        JLabel lblPassworf = new JLabel("PASSWORD                      :");
        lblPassworf.setBounds(62, 164, 180, 16);
        panel_1.add(lblPassworf);

        JLabel lblSecurityQuestions = new JLabel("SECURITY QUESTION        :  ");
        lblSecurityQuestions.setBounds(62, 207, 180, 16);
        panel_1.add(lblSecurityQuestions);

        uid = new JTextField();
        uid.setHorizontalAlignment(SwingConstants.CENTER);
        uid.setBackground(Color.WHITE);
        uid.setEditable(false);
        uid.setBounds(249, 40, 278, 26);
        panel_1.add(uid);
        uid.setColumns(10);

        fname = new JTextField();
        fname.setBounds(249, 78, 278, 26);
        panel_1.add(fname);
        fname.setColumns(10);

        lname = new JTextField();
        lname.setBounds(249, 117, 278, 26);
        panel_1.add(lname);
        lname.setColumns(10);

        sa = new JTextField();
        sa.setBounds(249, 246, 278, 26);
        panel_1.add(sa);
        sa.setColumns(10);

        JLabel lblSecurityAnswer = new JLabel("SECURITY ANSWER            :  ");
        lblSecurityAnswer.setBounds(62, 251, 180, 16);
        panel_1.add(lblSecurityAnswer);

        sq = new JComboBox();
        sq.setModel(new DefaultComboBoxModel(new String[] {"Which is your favorite animal?", "Who is your favorite Actor or Actress?", "Who is your first childhood friend?", "What is your hobby?", "Which is your dream Bike/Car?"}));
        sq.setBounds(249, 203, 283, 27);
        panel_1.add(sq);

        JButton regbutt = new JButton("REGISTER");
        regbutt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Register();
            }
        });
        regbutt.setBounds(257, 300, 117, 29);
        panel_1.add(regbutt);

        pass = new JPasswordField();
        pass.setBounds(254, 159, 273, 26);
        panel_1.add(pass);
    }

    private static void Randomize ()
    {
        Random r = new Random (); 
        int a =  r.nextInt(1000000+1);
        uid.setText(a+"");  
    }

    private static void Register ()
    {
        char[] pswrd = pass.getPassword();
        String pass2 = String.valueOf(pswrd);
        Calendar cal1 = new GregorianCalendar();

        java.util.Date CurrDate = cal1.getTime();
        cal1.setTime(CurrDate);
        cal1.add(Calendar.MONTH, 1);

        java.sql.Date SqlDate3 = new java.sql.Date(CurrDate.getTime());
        SimpleDateFormat DMY = new SimpleDateFormat("yyyy-mm-dd");
        DMY.format(SqlDate3);

        try 
        {
            PreparedStatement ps = Conn.prepareStatement("insert into admin_database values (?,?,?,?,?,?,?)");
            ps.setInt(1, Integer.parseInt(uid.getText()));
            ps.setString(2, fname.getText());
            ps.setString(3, lname.getText());
            ps.setString(4, pswrd.toString());
            ps.setString(5, sq.getSelectedItem().toString());
            ps.setString(6, sa.getText());
            ps.setDate(7, SqlDate3);

            int i = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thanks for Registering your UserID is "+uid.getText());
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
}