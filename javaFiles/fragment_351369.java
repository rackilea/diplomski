public class Test {
    JFrame frame;
    JPanel window;
    JTable table;
    JScrollPane scrollPane;

    Connection con;
    Statement sth;
    ResultSet rs;

    public void connect () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SMS", "root", "phplover");
        } catch (Exception e) {
            System.out.println("Conection failed. " + e);
        }
    }

    public void initGUI () {
        frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        window.setLayout(new BorderLayout());
        frame.add(window);

        scrollPane = new JScrollPane(table);

        // USE THIS ONE IF YOU WANT YOUR SCROLL BARS TO ALWAYS BE VISIBLE!
        //scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        window.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public void fetchRecords () {
        try {
            sth = con.createStatement();
            rs = sth.executeQuery("SELECT * FROM `students`");

            String[] columns = {"Name", "Father's Name", "Age"};

            List<Object[]> sets = new ArrayList<Object[]>();
            while (rs.next()) {
                String name = rs.getString("name");
                String fname = rs.getString("fname");
                String age = rs.getString("age");

                sets.add(new String[]{name, fname, age});
            }
            table = new JTable(sets.toArray(new Object[sets.size()][]), columns);
        } catch (Exception e) {
            System.out.println("An error occured. " + e);
        }
    }

    public static void main (String args[]) {
        Test obj = new Test();
        obj.connect();
        obj.fetchRecords(); // Notice I swapped the order between this and initGUI.
        obj.initGUI();      // The program will break if you have it the other way around as the
                            // JTable will throw a NullPointerException.
    }
}