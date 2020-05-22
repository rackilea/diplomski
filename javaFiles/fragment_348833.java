public class UI {

   private JPanel panel;
   private JTextArea output;

    public UI(){
       initialize();
    }


    private void initialize() {
        panel = new JPanel();
        Font myFont = new Font("Courier", Font.BOLD, 14);
        final JTextField input = new JTextField(""); // must be declared final cause you use it in anonymous class, you can make it instance variable if you want to as textArea

        //add an actionListener then when you press enter this will write to textArea
        input.addActionListener(new ActionListener(){
              @Override             
              public void actionPerformed(ActionEvent evt){
                     writeToArea(input.getText());
              }

        });


        output = new JTextArea("Initiated Succesfully",50,100);// let the component determinate its preferred size.
        output.setWrapStyleWord(true);
        output.setLineWrap(true);
        input.setFont(myFont);
        output.setFont(myFont);
        input.setForeground(Color.WHITE);
        output.setForeground(Color.WHITE);
        input.setBackground(Color.BLACK);
        input.setCaretColor(Color.WHITE);
        output.setBackground(Color.BLACK);
        output.setEditable(false);
        JScrollPane jp = new JScrollPane(output);
        panel.setLayout(new BorderLayout());
        panel.add(input, BorderLayout.SOUTH);
        panel.add(jp, BorderLayout.CENTER);

    }

    private void writeToArea(String something) {
        System.out.println("\"writeToArea\" running.");
        output.append(something);
        System.out.println("\"writeToArea\" finished.");
    }


    public JPanel getPanel(){
        return panel;
    }
}