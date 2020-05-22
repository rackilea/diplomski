public class Test {

    public static void main(String[] args) {
        CgpaCalculator window = new CgpaCalculator();
        window.getFrmCgpaCalculator().setVisible(true);
    }
}

class CgpaCalculator {
    private JFrame frmCgpaCalculator;

    private JPanel coursesPanel;
    private JScrollPane scrollPane;

    // Define some constants
    private int ROWS_Y_OFFEST = 0;
    private int ROW_HEIGHT = 35;
    private String[] credits = new String[] {"3", "1", "2", "0", "1.5"};
    private String[] grades = new String[] {"A", "A-", "B+", "B", "B", "B-", "C+", "C", "D+", "D", "F"};

    // This list holds all the row elements
    private List<CourseRow> courseRows = new ArrayList<>();

    // These 2 need to be class variable because we update them in the refresh method
    private JButton btnNewButton, btnCalculate;

    public CgpaCalculator() {
        initializeElements();
        refresh();
    }

    private void initializeElements() {
        frmCgpaCalculator = new JFrame();
        frmCgpaCalculator.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 17));
        frmCgpaCalculator.setTitle("CGPA Calculator");
        frmCgpaCalculator.setBounds(100, 100, 540, 683);
        frmCgpaCalculator.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frmCgpaCalculator.getContentPane().setLayout(null);

        // CGPA RESULT
        JLabel lblCgpa = new JLabel("CGPA:");
        lblCgpa.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblCgpa.setBounds(386, 13, 56, 16);
        frmCgpaCalculator.getContentPane().add(lblCgpa);

        JLabel label = new JLabel("0.0");
        label.setFont(new Font("Tahoma", Font.PLAIN, 17));
        label.setBounds(454, 13, 56, 16);
        frmCgpaCalculator.getContentPane().add(label);

        // HEADERS
        JLabel lblCourse = new JLabel("Course");
        lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCourse.setBounds(47, 99, 56, 16);
        frmCgpaCalculator.getContentPane().add(lblCourse);

        JLabel lblCredits = new JLabel("Credits");
        lblCredits.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCredits.setBounds(192, 99, 56, 16);
        frmCgpaCalculator.getContentPane().add(lblCredits);

        JLabel lblGrade = new JLabel("Grade");
        lblGrade.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblGrade.setBounds(311, 99, 56, 16);
        frmCgpaCalculator.getContentPane().add(lblGrade);


        // Courses panel and scroll pane
        coursesPanel = new JPanel();
        coursesPanel.setLayout(null);

        scrollPane = new JScrollPane(coursesPanel);
        scrollPane.setBounds(40, 150, 480, 300);
        scrollPane.setPreferredSize(new Dimension(500, 300));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        frmCgpaCalculator.getContentPane().add(scrollPane);

        // BUTTONS
        btnNewButton = new JButton("Add Course");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(12, 500, 124, 25);
        btnNewButton.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent arg0) {
                   addCourseRow();
               }
           }
        );
        frmCgpaCalculator.getContentPane().add(btnNewButton);

        btnCalculate = new JButton("Calculate");
        btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnCalculate.setBounds(270, 500, 97, 25);
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                label.setText("3.2");
            }
        });
        frmCgpaCalculator.getContentPane().add(btnCalculate);


        // Add 3 default rows
        addCourseRow();
        addCourseRow();
        addCourseRow();
    }

    // This method refreshes the view.
    // It takes the list of course rows and reposition them depending on their index in the list
    // This enabled to easily handle deleting rows in the middle
    private void refresh() {

        // Reposition all course rows
        int rowY = ROWS_Y_OFFEST;
        CourseRow courseRow;
        for(int rowIndex=0; rowIndex<courseRows.size(); rowIndex++) {
            courseRow = courseRows.get(rowIndex);
            rowY = ROWS_Y_OFFEST + rowIndex * ROW_HEIGHT;

            courseRow.getNameJTextField().setBounds(12, rowY, 126, 29);
            courseRow.getCreditsJComboBox().setBounds(181, rowY, 75, 29);
            courseRow.getGradeJComboBox().setBounds(297, rowY, 70, 29);
            courseRow.getDeleteJButton().setBounds(428, rowY, 30, 30);
        }

        // resize the course panel so the scroll pane knows if it needs to add the scroll bar
        // you need to use the setPreferredSize method
        coursesPanel.setPreferredSize(new Dimension(450, rowY + ROW_HEIGHT));

        // repaint the scroll pane
        scrollPane.invalidate();
        scrollPane.validate();
        scrollPane.repaint();
    }

    private void addCourseRow() {
        // Calculate the Y coordinate of the row
        long rowId = System.currentTimeMillis();

        // Create the 3 elements
        JTextField nameJTextField = new JTextField();
        nameJTextField.setColumns(10);
        coursesPanel.add(nameJTextField);

        JComboBox creditsJComboBox = new JComboBox();
        creditsJComboBox.setToolTipText("0");
        creditsJComboBox.setModel(new DefaultComboBoxModel(credits));
        coursesPanel.add(creditsJComboBox);

        JComboBox gradeJComboBox = new JComboBox();
        gradeJComboBox.setModel(new DefaultComboBoxModel(grades));
        coursesPanel.add(gradeJComboBox);

        JButton btnX = new JButton("");
        btnX.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeCourse(rowId);
            }
        });
        btnX.setIcon(new ImageIcon(CgpaCalculator.class.getResource("/com/sun/javafx/scene/control/skin/modena/dialog-error.png")));
        btnX.setBackground(Color.RED);
        btnX.setForeground(Color.WHITE);
        coursesPanel.add(btnX);

        // Add the row to the list
        CourseRow courseRow = new CourseRow();
        courseRow.setId(rowId);
        courseRow.setNameJTextField(nameJTextField);
        courseRow.setCreditsJComboBox(creditsJComboBox);
        courseRow.setGradeJComboBox(gradeJComboBox);
        courseRow.setDeleteJButton(btnX);
        courseRows.add(courseRow);

        refresh();
    }

    private void removeCourse(long rowId) {
        // find the course row by id
        Optional<CourseRow> rowOption = courseRows.stream().filter(r -> r.getId() == rowId).findFirst();
        if(rowOption.isPresent()) {
            CourseRow row = rowOption.get();
            // remove elements of this row from the JFrame
            coursesPanel.remove(row.getNameJTextField());
            coursesPanel.remove(row.getCreditsJComboBox());
            coursesPanel.remove(row.getGradeJComboBox());
            coursesPanel.remove(row.getDeleteJButton());

            // remove row from the list
            courseRows.remove(row);
        } else {
            System.out.println("Could not find row with id "+rowId);
        }

        refresh();
    }



    public JFrame getFrmCgpaCalculator() {
        return frmCgpaCalculator;
    }
}

class CourseRow {
    private long id;
    private JTextField nameJTextField;
    private JComboBox creditsJComboBox;
    private JComboBox gradeJComboBox;
    private JButton deleteJButton;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public JTextField getNameJTextField() {
        return nameJTextField;
    }

    public void setNameJTextField(JTextField nameJTextField) {
        this.nameJTextField = nameJTextField;
    }

    public JComboBox getCreditsJComboBox() {
        return creditsJComboBox;
    }

    public void setCreditsJComboBox(JComboBox creditsJComboBox) {
        this.creditsJComboBox = creditsJComboBox;
    }

    public JComboBox getGradeJComboBox() {
        return gradeJComboBox;
    }

    public void setGradeJComboBox(JComboBox gradeJComboBox) {
        this.gradeJComboBox = gradeJComboBox;
    }

    public JButton getDeleteJButton() {
        return deleteJButton;
    }

    public void setDeleteJButton(JButton deleteJButton) {
        this.deleteJButton = deleteJButton;
    }
}