public void initialize() {

/* Your same code */
frame = new JFrame();
frame.getContentPane().setBackground(Color.DARK_GRAY);
frame.setBounds(100, 100, 450, 132);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);

JButton btnAddNewDebt = new JButton("Add new debt");
btnAddNewDebt.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent e) {
        DebtForm debtForm = new DebtForm();
        debtForm.setVisible(true);
        /* THE ONLY NEW LINE OF CODE */
        frame.setVisible(false); //This will make the first window disapear.
        /* ------------------------- */
    }
});

btnAddNewDebt.setBounds(81, 18, 117, 29);
frame.getContentPane().add(btnAddNewDebt);      

JButton btnPersonalDebt = new JButton("Personal Debt");
btnPersonalDebt.setBounds(266, 18, 117, 29);
frame.getContentPane().add(btnPersonalDebt);

JLabel lblWrittenAndCoded = new JLabel("Written and coded by Samuel Kahessay");
lblWrittenAndCoded.setForeground(Color.WHITE);
lblWrittenAndCoded.setBounds(108, 88, 252, 16);
frame.getContentPane().add(lblWrittenAndCoded);
}