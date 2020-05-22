public class BoxFrame extends JFrame {
    private JComboBox jcbox1 = new JComboBox(model1);
    private JComboBox jcbox2 = new JComboBox(model2);
    private JComboBox jcbox3 = new JComboBox(model3);
    private JLabel jlb1 = newJLabel("Question1");
    private JLabel jlb2 = newJLabel("Question2");
    private JLabel jlb3 = newJLabel("Question3");
    private JButton jbtSubmit = newJButton("Submit");

    public BoxFrame(){
        JPanel panel = new JPanel(new GridLayout(6, 1));
        panel.add(jlb1);
        panel.add(jcbox1);
        panel.add(jlb2);
        panel.add(jcbox2);
        panel.add(jlb3);
        panel.add(jcbox3);

        setLayout(new BorderLayout(5,5))
        add(panel, BorderLayout.CENTER);
        add(jbtSubmit,BorderLayout.SOUTH);

        jbtSumbit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String cb1 = jcbox1.getItemSelected();
                String cb2 = jcbox2.getItemSelected();
                String cb3 = jcbox13.getItemSelected();

                // do something with Strings
            }
        });
    }

    public static void main(String[] args){
        BoxFrame frame = new BoxFrame();
        frame.pack();
        frame.setTitle("ComboBoxes);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationReltaiveTo(null);
        frame.setVisible();
    }

}