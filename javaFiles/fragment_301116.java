public WiP_QuestionBoard() {
        initComponents();

        //Makes the table header text centered.
        ((DefaultTableCellRenderer) tblQuestions.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        //This will center the text in table (header not included).
        DefaultTableCellRenderer centerAlign = new DefaultTableCellRenderer();

        //center columns.
        centerAlign.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tblQuestions.getColumnCount(); i++) {
            tblQuestions.getColumnModel().getColumn(i).setCellRenderer(centerAlign);
        }

        //makes the table span the panel it is in.
        tblQuestions.setPreferredSize(this.panelQuestions.getPreferredSize());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }