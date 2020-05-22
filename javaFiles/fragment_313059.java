public class mainFrame extends JFrame implements ActionListener {
    ........
    private JButton answer1 = new JButton();
    String [] a = {"a","b","c","d","e"}
    in fileNumber = 0; 
}

public mainFrame (){
    nextString();
    answer1.addActionListener(this); 
}

public void actionPerformed(ActionEvent e) {     
    if (e.getSource==answer1) nextString();
}

private void nextString() {
    try {
        .....
        System.out.println(a.get(fileNumber))
        fout = new FileOutputStream ("myfile.txt",true);
        Filename = new File(files.get(fileNumber));      
        new PrintStream(fout).println (Filename);
        new PrintStream(fout).println ("Answer 1");
        fileNumber++;      
    }
    ...
}