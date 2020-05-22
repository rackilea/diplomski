public class CollectionBooksTest extends javax.swing.JFrame {

Connection conn, concb, concb2, conck = null;
ResultSet rs = null;
PreparedStatement pst = null;
Statement stcb, stcb2, stck = null;

/** Creates new form CollectionBooks */
public CollectionBooksTest() {
    initComponents();
    conn = connectjava.ConnecrDb();
    PopulateJTable();
}

private void PopulateJTable() {
    //jComboBox One part 1/2
    Vector cbItems = new Vector();
    try {
        Class.forName("org.sqlite.JDBC");
        concb = DriverManager.getConnection("jdbc:sqlite://ThePathToYourDatabase/TheNameOfYourDatabase.db");
        stcb = concb.createStatement();
        String sqlcb = "SELECT firstname, middlename, lastname FROM authors ORDER BY lastname ASC";
        ResultSet rscb = stcb.executeQuery(sqlcb);
        int row = 0;
        while ((rscb != null) && (rscb.next())) {
            cbItems.add(rscb.getString("firstname") + " " + rscb.getString("middlename") + " " + rscb.getString("lastname"));
        }
        rscb.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        e.printStackTrace();
    }
    try {
        if (stcb != null) {
            stcb.close();
            concb.close();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    //jComboBox One part 2/2
    DefaultComboBoxModel cbm = new DefaultComboBoxModel(cbItems);
    final JComboBox cb = new JComboBox(cbm);

    //jComboBox Two part 1/2
    Vector cb2Items = new Vector();
    try {
        Class.forName("org.sqlite.JDBC");
        concb2 = DriverManager.getConnection("jdbc:sqlite://ThePathToYourDatabase/TheNameOfYourDatabase.db");
        stcb2 = concb2.createStatement();
        String sqlcb2 = "SELECT genre FROM genres ORDER BY genre ASC";
        ResultSet rscb2 = stcb2.executeQuery(sqlcb2);
        int row = 0;
        while ((rscb2 != null) && (rscb2.next())) {
            cb2Items.add(rscb2.getString("genre"));
        }
        rscb2.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        e.printStackTrace();
    }
    try {
        if (stcb2 != null) {
            stcb2.close();
            concb2.close();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    //jComboBox Two part 2/2
    DefaultComboBoxModel cb2model = new DefaultComboBoxModel(cb2Items);
    final JComboBox cb2 = new JComboBox(cb2model);


    //populate jTable adding comboboxes, etc
    String sql = "Select markread as 'Read', title as 'Title', authorid as 'Author', genreid as 'Genre', notes as 'Notes' from books";
    try {
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        jTable1_pumpdata.setModel(DbUtils.resultSetToTableModel(rs));
        jTable1_pumpdata.setAutoCreateRowSorter(true);
        //add checkbox
        CheckBoxRenderer rchb = new CheckBoxRenderer();
        jTable1_pumpdata.getColumnModel().getColumn(0).setCellRenderer(rchb);
        JCheckBox chb = new JCheckBox();
        chb.setHorizontalAlignment(JLabel.CENTER);
        TableColumn tchb = jTable1_pumpdata.getColumnModel().getColumn(0);
        DefaultCellEditor e = new DefaultCellEditor(chb);
        tchb.setCellEditor(e);
        //add comboboxes
        TableColumn tcb = jTable1_pumpdata.getColumnModel().getColumn(2);
        DefaultCellEditor e2 = new DefaultCellEditor(cb);
        tcb.setCellEditor(e2);
        TableColumn tcb2 = jTable1_pumpdata.getColumnModel().getColumn(3);
        DefaultCellEditor e3 = new DefaultCellEditor(cb2);
        tcb2.setCellEditor(e3);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    } finally {
        try {
            rs.close();
            pst.close();
        } catch (Exception e) {
        }
    }
}