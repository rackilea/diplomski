public class YourHEad 
{

    public static void main(String[] args) 
    {
    final JFrame frame = new JFrame("GridLayout Test");
    frame.setLayout(new GridLayout(4, 4));

    StringBuilder sb = new StringBuilder();
    sb.append("<html>");

    String[][] seats = new String [4][4];
    String alpha = "ABCD";

    for (int i=0; i<4; i++){

        String letter = Character.toString(alpha.charAt(i));

        for (int j=0; j<4; j++){

            String number = Integer.toString(j+1);
            seats [i][j]=letter+number+" ";

        }
    }

for (int i = 0; i < 4; i++){
    for (int j = 0; j < 4; j++){
        JButton button= new JButton(seats[i][j]);
        button.addMouseListener(new MouseAdapter()
                {
                    public void mouseClicked(MouseEvent e) 
                    {
                        JOptionPane.showMessageDialog(frame, ((JButton)(e.getSource())).getText()+" is Pressed");
                    }
                });
         frame.add(button);
    }
}

frame.pack();
frame.setVisible(true);

}
}