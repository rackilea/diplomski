import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;
    import java.awt.event.ActionListener;
    import java.sql.*;
    import java.util.Vector;

    public class Project_SalesDatabase extends JFrame {

    JTabbedPane tabbedPane = new JTabbedPane();
    ImageIcon icon = createImageIcon("images/middle.gif");
    JButton view = new JButton(" View ");
    JButton save = new JButton(" Save ");
    JButton addNew = new JButton(" Add New ");
    JButton exit = new JButton(" Exit Application ");

    JPanel displayBiscuitsPanel = new JPanel();
    JPanel displayCookingPanel = new JPanel();
    JPanel displayCustomersPanel = new JPanel();
    JPanel displayEmployeesPanel = new JPanel();
    JPanel displayProvisionsPanel = new JPanel();

    JPanel displayButton = new JPanel();
    JPanel displayButton1 = new JPanel();
    JPanel displayButton2 = new JPanel();
    JPanel displayButton3 = new JPanel();
    JPanel displayButton4 = new JPanel();

    JPanel displayContent = new JPanel((new GridLayout(10, 2)));
    JPanel displayContent1 = new JPanel((new GridLayout(10, 2)));
    JPanel displayContent2 = new JPanel((new GridLayout(10, 2)));
    JPanel displayContent3 = new JPanel((new GridLayout(10, 2)));
    JPanel displayContent4 = new JPanel((new GridLayout(10, 2)));


    JPanel displayTable = new JPanel(new GridLayout(1, 2));
    JPanel displayTable1 = new JPanel(new GridLayout(1, 2));
    JPanel displayTable2 = new JPanel(new GridLayout(1, 2));
    JPanel displayTable3 = new JPanel(new GridLayout(1, 2));
    JPanel displayTable4 = new JPanel(new GridLayout(1, 2));


    JTextField biscuitName = new JTextField();
    JTextField biscuitPrice = new JTextField();
    JTextField biscuitCompany = new JTextField();
    JTextField quantityOfBiscuitsBought = new JTextField();
    JTextField quantityOfBiscuitsSold = new JTextField();
    JTextField quantityInStock = new JTextField();
    JTextField itemName = new JTextField();
    JTextField itemPrice = new JTextField();
    JTextField itemType = new JTextField();
    JTextField quantityOfitemsBought = new JTextField();
    JTextField quantityOfitemsSold = new JTextField();
    JTextField firstName = new JTextField();
    JTextField lastName = new JTextField();
    JTextField customerAttendant = new JTextField();
    JTextField customerAttendantPosition = new JTextField();
    JTextField isCustomerADebtor = new JTextField();
    JTextField orderNumber = new JTextField();
    JTextField debtAmount = new JTextField();
    JTextField address = new JTextField();
    JTextField phoneNumber = new JTextField();
    JTextField position = new JTextField();
    JTextField age = new JTextField();
    JTextField salary = new JTextField();
    JTextField nextOfKin = new JTextField();
    JTextField relationshipWithNextOfKin = new JTextField();
    JTextField nextOfKinPhoneNumber = new JTextField();
    JTextField itemCompany = new JTextField();

    public static void main(String[] args) {
        Project_SalesDatabase mainFrame = new Project_SalesDatabase();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Project_SalesDatabase() {

        setTitle(" Database App ");
        setSize(1000, 500);

        // Create the tab pages
        biscuitsTable();
        cookingIngredientsTable();
        customersTable();
        employeesTable();
        provisionsTable();

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1, 3));
        getContentPane().add(topPanel);
        topPanel.add(tabbedPane, BorderLayout.CENTER);


        // Create tabs in tabbedPane
        tabbedPane.addTab("Biscuits Database", icon, displayBiscuitsPanel,
                "Allows you to view or Enter Data into the Biscuits Database");

        tabbedPane.addTab("Cooking Ingredients Database", icon, displayCookingPanel,
                "Allows you to view or Enter Data into the Cooking Ingredients Database");

        tabbedPane.addTab("Customers Database", icon, displayCustomersPanel,
                "Allows you to view or Enter Data into the Customers Database");

        tabbedPane.addTab("Employees Database", icon, displayEmployeesPanel,
                "Allows you to view or Enter Data into the Employees Database");

        tabbedPane.addTab("Provisions Database", icon, displayProvisionsPanel,
                "Allows you to view or Enter Data into the Provisions Database");

        //Enable scrolling in tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    public static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Project_SalesDatabase.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public final void biscuitsTable() {
        displayBiscuitsPanel.setLayout(new BorderLayout());
        displayBiscuitsPanel.add(displayContent, BorderLayout.CENTER);
        displayBiscuitsPanel.add(displayButton, BorderLayout.SOUTH);
        displayBiscuitsPanel.add(displayTable, BorderLayout.NORTH);

        displayContent.add(new JLabel("Biscuit Name"));
        displayContent.add(biscuitName);
        displayContent.add(new JLabel("Biscuit Price"));
        displayContent.add(biscuitPrice);
        displayContent.add(new JLabel("Biscuit Company"));
        displayContent.add(biscuitCompany);
        displayContent.add(new JLabel("Quantity Of Biscuits Bought"));
        displayContent.add(quantityOfBiscuitsBought);
        displayContent.add(new JLabel("Quantity Of Biscuits Sold"));
        displayContent.add(quantityOfBiscuitsSold);
        displayContent.add(new JLabel("Quantity In Stock"));
        displayContent.add(quantityInStock);

        displayButton.add(addNew);
        displayButton.add(save);
        displayButton.add(view);
        displayButton.add(exit);

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String db_url = "jdbc:odbc:ProjectSalesDatabase";
                String username = "";
                String password = "";
                Connection con = null;

                try {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    con = DriverManager.getConnection(db_url, username, password);
                } catch (ClassNotFoundException | SQLException f) {
                    JOptionPane.showMessageDialog(rootPane, f.getMessage());
                }

                Statement state = null;
                ResultSet set = null;

                try {

                    String Query = "SELECT * FROM Biscuits";
                    state = con.createStatement();
                    set = state.executeQuery(Query);

                    boolean nextrec = set.next();
                    if (!nextrec) {
                        JOptionPane.showMessageDialog(rootPane, "No Record");
                    } else {
                        Vector col = new Vector();
                        Vector row = new Vector();

                        ResultSetMetaData rsm = set.getMetaData();

                        for (int x = 1; x <= rsm.getColumnCount(); x++) {
                            col.addElement(rsm.getColumnName(x));
                        }
                        do {
                            row.addElement(getNextRow(set, rsm));
                        } while (set.next());

                        JTable tab = new JTable(row, col);
                        displayContent.removeAll();
                        displayTable.removeAll();
                        displayTable.add(new JScrollPane(tab), BorderLayout.CENTER);

                        validate();
                    }
                    state.close();
                } catch (SQLException sql) {
                    JOptionPane.showMessageDialog(rootPane, sql.getMessage());
                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String Query = "INSERT INTO Biscuits VALUES ('" + biscuitName.getText() + "',"
                            + "          '" + biscuitPrice.getText() + "',"
                            + "          '" + biscuitCompany.getText() + "',"
                            + "          '" + quantityOfBiscuitsBought.getText() + "',"
                            + "          '" + quantityOfBiscuitsSold.getText() + "',"
                            + "          '" + quantityInStock.getText() + "')";

                    String db_url = "jdbc:odbc:ProjectSalesDatabase";
                    String username = "";
                    String password = "";
                    Connection con = null;
                    try {
                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        con = DriverManager.getConnection(db_url, username, password);
                    } catch (ClassNotFoundException | SQLException f) {

                        JOptionPane.showMessageDialog(rootPane, f.getMessage());
                    }
                    Statement state = con.createStatement();
                    int rep = state.executeUpdate(Query);
                    if (rep == 0) {
                        JOptionPane.showMessageDialog(rootPane, "No Data Saved");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Data Saved");
                    }
                } catch (SQLException sqle) {
                    sqle.getMessage();
                }
            }
        });

        addNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    biscuitName.setText("");
                    biscuitPrice.setText("");
                    biscuitCompany.setText("");
                    quantityOfBiscuitsBought.setText("");
                    quantityOfBiscuitsSold.setText("");
                    quantityInStock.setText("");

                    displayTable.removeAll();
                    displayContent.removeAll();

                    displayContent.add(new JLabel("Biscuit Name"));
                    displayContent.add(biscuitName);
                    displayContent.add(new JLabel("Biscuit Price"));
                    displayContent.add(biscuitPrice);
                    displayContent.add(new JLabel("Biscuit Company"));
                    displayContent.add(biscuitCompany);
                    displayContent.add(new JLabel("Quantity Of Biscuits Bought"));
                    displayContent.add(quantityOfBiscuitsBought);
                    displayContent.add(new JLabel("Quantity Of Biscuits Sold"));
                    displayContent.add(quantityOfBiscuitsSold);
                    displayContent.add(new JLabel("Quantity In Stock"));
                    displayContent.add(quantityInStock);

                    validate();

                } catch (Exception f) {
                    f.getMessage();
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public final void cookingIngredientsTable() {
        displayCookingPanel.setLayout(new BorderLayout());
        displayCookingPanel.add(displayContent1, BorderLayout.CENTER);
        displayCookingPanel.add(displayButton1, BorderLayout.SOUTH);
        displayCookingPanel.add(displayTable1, BorderLayout.NORTH);

        displayContent1.add(new JLabel("Item Name"));
        displayContent1.add(itemName);
        displayContent1.add(new JLabel("Item Price"));
        displayContent1.add(itemPrice);
        displayContent1.add(new JLabel("Item Type"));
        displayContent1.add(itemType);
        displayContent1.add(new JLabel("Quantity Of Items Bought"));
        displayContent1.add(quantityOfitemsBought);
        displayContent1.add(new JLabel("Quantity Of Items Sold"));
        displayContent1.add(quantityOfitemsSold);
        displayContent1.add(new JLabel("Quantity In Stock"));
        displayContent1.add(quantityInStock);

        displayButton1.add(addNew);
        displayButton1.add(save);
        displayButton1.add(view);
        displayButton1.add(exit);

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String db_url = "jdbc:odbc:ProjectSalesDatabase";
                String username = "";
                String password = "";
                Connection con = null;
                try {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    con = DriverManager.getConnection(db_url, username, password);
                } catch (ClassNotFoundException | SQLException f) {
                    JOptionPane.showMessageDialog(rootPane, f.getMessage());
                }

                Statement state = null;
                ResultSet set = null;

                try {

                    String Query = "SELECT * FROM CookingIngredients";
                    state = con.createStatement();
                    set = state.executeQuery(Query);

                    boolean nextrec = set.next();
                    if (!nextrec) {
                        JOptionPane.showMessageDialog(rootPane, "No Record");
                    } else {
                        Vector col = new Vector();
                        Vector row = new Vector();

                        ResultSetMetaData rsm = set.getMetaData();

                        for (int x = 1; x <= rsm.getColumnCount(); x++) {
                            col.addElement(rsm.getColumnName(x));
                        }
                        do {
                            row.addElement(getNextRow(set, rsm));
                        } while (set.next());
                        JTable tab = new JTable(row, col);
                        displayContent.removeAll();
                        displayTable.removeAll();
                        displayTable.add(new JScrollPane(tab), BorderLayout.CENTER);
                        validate();
                    }
                    state.close();

                } catch (SQLException sql) {
                    JOptionPane.showMessageDialog(rootPane, sql.getMessage());
                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String Query = "INSERT INTO CookingIngredients VALUES ('" + itemName.getText() + "',"
                            + "          '" + itemPrice.getText() + "',"
                            + "          '" + itemType.getText() + "',"
                            + "          '" + quantityOfitemsBought.getText() + "',"
                            + "          '" + quantityOfitemsSold.getText() + "',"
                            + "          '" + quantityInStock.getText() + "')";

                    String db_url = "jdbc:odbc:ProjectSalesDatabase";
                    String username = "";
                    String password = "";
                    Connection con = null;
                    try {
                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        con = DriverManager.getConnection(db_url, username, password);
                    } catch (ClassNotFoundException | SQLException f) {
                        JOptionPane.showMessageDialog(rootPane, f.getMessage());
                    }
                    Statement state = con.createStatement();
                    int rep = state.executeUpdate(Query);
                    if (rep == 0) {
                        JOptionPane.showMessageDialog(rootPane, "No Data Saved");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Data Saved");
                    }
                } catch (SQLException sqle) {
                    sqle.getMessage();
                }
            }
        });

        addNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    itemName.setText("");
                    itemPrice.setText("");
                    itemType.setText("");
                    quantityOfitemsBought.setText("");
                    quantityOfBiscuitsSold.setText("");
                    quantityOfitemsSold.setText("");
                    quantityInStock.setText("");

                    displayTable.removeAll();
                    displayContent.removeAll();

                    displayContent.add(new JLabel("Item Name"));
                    displayContent.add(itemName);
                    displayContent.add(new JLabel("Item Price"));
                    displayContent.add(itemPrice);
                    displayContent.add(new JLabel("Item Type"));
                    displayContent.add(itemType);
                    displayContent.add(new JLabel("Quantity Of Items Bought"));
                    displayContent.add(quantityOfitemsBought);
                    displayContent.add(new JLabel("Quantity Of Items Sold"));
                    displayContent.add(quantityOfitemsSold);
                    displayContent.add(new JLabel("Quantity In Stock"));
                    displayContent.add(quantityInStock);

                    validate();

                } catch (Exception f) {
                    f.getMessage();
                }
            }
        });
    }

    public final void customersTable() {
        displayCustomersPanel.setLayout(new BorderLayout());
        displayCustomersPanel.add(displayContent2, BorderLayout.CENTER);
        displayCustomersPanel.add(displayButton2, BorderLayout.SOUTH);
        displayCustomersPanel.add(displayTable2, BorderLayout.NORTH);

        displayContent2.add(new JLabel("First Name"));
        displayContent2.add(firstName);
        displayContent2.add(new JLabel("Last Name"));
        displayContent2.add(lastName);
        displayContent2.add(new JLabel("Customer Attendant"));
        displayContent2.add(customerAttendant);
        displayContent2.add(new JLabel("Customer Attendant's Position"));
        displayContent2.add(customerAttendantPosition);
        displayContent2.add(new JLabel("Is This Customer A Debtor?"));
        displayContent2.add(isCustomerADebtor);
        displayContent2.add(new JLabel("Order Number"));
        displayContent2.add(orderNumber);
        displayContent2.add(new JLabel("Debt Amount"));
        displayContent2.add(debtAmount);
        displayContent2.add(new JLabel("Customer's Address"));
        displayContent2.add(address);
        displayContent2.add(new JLabel("Customer's Phone Number"));
        displayContent2.add(phoneNumber);

        displayButton2.add(addNew);
        displayButton2.add(save);
        displayButton2.add(view);
        displayButton2.add(exit);

        //button actions same as other methods. Removed it because of body character limits
    }

    public final void employeesTable() {
        displayEmployeesPanel.setLayout(new BorderLayout());
        displayEmployeesPanel.add(displayContent3, BorderLayout.CENTER);
        displayEmployeesPanel.add(displayButton3, BorderLayout.SOUTH);
        displayEmployeesPanel.add(displayTable3, BorderLayout.NORTH);

        displayContent3.add(new JLabel("First Name"));
        displayContent3.add(firstName);
        displayContent3.add(new JLabel("Last Name"));
        displayContent3.add(lastName);
        displayContent3.add(new JLabel("Position"));
        displayContent3.add(position);
        displayContent3.add(new JLabel("Age"));
        displayContent3.add(age);
        displayContent3.add(new JLabel("Salary"));
        displayContent3.add(salary);
        displayContent3.add(new JLabel("Employees's Address"));
        displayContent3.add(address);
        displayContent3.add(new JLabel("Employees's Phone Number(s)"));
        displayContent3.add(phoneNumber);
        displayContent3.add(new JLabel("Next of Kin"));
        displayContent3.add(nextOfKin);
        displayContent3.add(new JLabel("Relationship With Next of Kin"));
        displayContent3.add(relationshipWithNextOfKin);
        displayContent3.add(new JLabel("Next of Kin's Phone Number(s)"));
        displayContent3.add(nextOfKinPhoneNumber);

        displayButton3.add(addNew);
        displayButton3.add(save);
        displayButton3.add(view);
        displayButton3.add(exit);

        //button actions same as other methods. Removed it because of body character limits
    }

    public final void provisionsTable() {
        displayProvisionsPanel.setLayout(new BorderLayout());
        displayProvisionsPanel.add(displayContent4, BorderLayout.CENTER);
        displayProvisionsPanel.add(displayButton4, BorderLayout.SOUTH);
        displayProvisionsPanel.add(displayTable4, BorderLayout.NORTH);

        displayContent4.add(new JLabel("Item Name"));
        displayContent4.add(itemName);
        displayContent4.add(new JLabel("Item Price"));
        displayContent4.add(itemPrice);
        displayContent4.add(new JLabel("Item Company"));
        displayContent4.add(itemCompany);
        displayContent4.add(new JLabel("Quantity Of Items Bought"));
        displayContent4.add(quantityOfitemsBought);
        displayContent4.add(new JLabel("Quantity Of Items Sold"));
        displayContent4.add(quantityOfitemsSold);
        displayContent4.add(new JLabel("Quantity In Stock"));
        displayContent4.add(quantityInStock);

        displayButton4.add(addNew);
        displayButton4.add(save);
        displayButton4.add(view);
        displayButton4.add(exit);

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String db_url = "jdbc:odbc:ProjectSalesDatabase";
                String username = "";
                String password = "";
                Connection con = null;
                try {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    con = DriverManager.getConnection(db_url, username, password);
                } catch (ClassNotFoundException | SQLException f) {
                    JOptionPane.showMessageDialog(rootPane, f.getMessage());
                }

                Statement state = null;
                ResultSet set = null;

                try {

                    String Query = "SELECT * FROM Provisions";
                    state = con.createStatement();
                    set = state.executeQuery(Query);

                    boolean nextrec = set.next();
                    if (!nextrec) {
                        JOptionPane.showMessageDialog(rootPane, "No Record");
                    } else {
                        Vector col = new Vector();
                        Vector row = new Vector();

                        ResultSetMetaData rsm = set.getMetaData();

                        for (int x = 1; x <= rsm.getColumnCount(); x++) {
                            col.addElement(rsm.getColumnName(x));
                        }
                        do {
                            row.addElement(getNextRow(set, rsm));
                        } while (set.next());

                        JTable tab = new JTable(row, col);
                        displayContent.removeAll();
                        displayTable.removeAll();
                        displayTable.add(new JScrollPane(tab), BorderLayout.CENTER);

                        validate();
                    }
                    state.close();
                } catch (SQLException sql) {
                    JOptionPane.showMessageDialog(rootPane, sql.getMessage());
                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String Query = "INSERT INTO Provisions VALUES ('" + itemName.getText() + "',"
                            + "          '" + itemPrice.getText() + "',"
                            + "          '" + itemCompany.getText() + "',"
                            + "          '" + quantityOfitemsBought.getText() + "',"
                            + "          '" + quantityOfitemsSold.getText() + "',"
                            + "          '" + quantityInStock.getText() + "')";

                    String db_url = "jdbc:odbc:ProjectSalesDatabase";
                    String username = "";
                    String password = "";
                    Connection con = null;
                    try {
                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        con = DriverManager.getConnection(db_url, username, password);
                    } catch (ClassNotFoundException | SQLException f) {
                        JOptionPane.showMessageDialog(rootPane, f.getMessage());
                    }
                    Statement state = con.createStatement();
                    int rep = state.executeUpdate(Query);
                    if (rep == 0) {
                        JOptionPane.showMessageDialog(rootPane, "No Data Saved");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Data Saved");
                    }
                } catch (SQLException sqle) {
                    sqle.getMessage();
                }
            }
        });

        addNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    itemName.setText("");
                    itemPrice.setText("");
                    itemCompany.setText("");
                    quantityOfitemsBought.setText("");
                    quantityOfitemsSold.setText("");
                    quantityInStock.setText("");

                    displayTable.removeAll();
                    displayContent.removeAll();

                    displayContent.add(new JLabel("Item Name"));
                    displayContent.add(itemName);
                    displayContent.add(new JLabel("Item Price"));
                    displayContent.add(itemPrice);
                    displayContent.add(new JLabel("Item Company"));
                    displayContent.add(itemCompany);
                    displayContent.add(new JLabel("Quantity Of Items Bought"));
                    displayContent.add(quantityOfitemsBought);
                    displayContent.add(new JLabel("Quantity Of Items Sold"));
                    displayContent.add(quantityOfitemsSold);
                    displayContent.add(new JLabel("Quantity In Stock"));
                    displayContent.add(quantityInStock);

                    validate();

                } catch (Exception f) {
                    f.getMessage();
                }
            }
        });
    }

    Vector getNextRow(ResultSet set, ResultSetMetaData rsm) {
        Vector currentRow = new Vector();
        try {
            for (int x = 1; x <= rsm.getColumnCount(); x++) {
                switch (rsm.getColumnType(x)) {
                    case Types.VARCHAR:
                        currentRow.addElement(set.getString(x));
                        break;
                    case Types.INTEGER:
                        currentRow.addElement(new Long(set.getLong(x)));
                        break;
                    default:
                        System.out.println("No column type known");
                        break;
                }
            }
        } catch (SQLException sqle) {
            sqle.getMessage();
        }
        return currentRow;
    }
    }