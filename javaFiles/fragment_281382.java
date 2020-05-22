public class MyFileLister extends JPanel implements ActionListener {

private JLabel prompt = null;  
private JTextField userInput = null;    
private JTextArea textArea = null;

public MyFileLister()
{
    prompt = new JLabel("Enter filename: ");
    prompt.setOpaque(true);
    this.add(prompt);

    userInput = new JTextField(28);
    userInput.addActionListener(this);
    this.add(userInput);

    textArea = new JTextArea(10, 30);
    textArea.setOpaque(true);
    JScrollPane scrollpane = new JScrollPane(textArea);
    this.add(scrollpane, BorderLayout.SOUTH);
}

Scanner s = null;
File af ;
String[] paths;

public void actionPerformed(ActionEvent f)
{
    try
    {
        s = new Scanner(new File(userInput.getText()));

        while(s.hasNext())
        {
            String as = s.next();
            textArea.setText(as);
        }

    }
    catch(FileNotFoundException e)
    {
        af = new File(userInput.getText());

        paths = af.list();
       System.out.println(Arrays.toString(paths));

       String tempPath=""; 
        for(String path: paths)
        {
           tempPath+=path+"\n";

        }
        textArea.setText(tempPath);

    }
}
}