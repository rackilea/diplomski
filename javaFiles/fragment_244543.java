public static void main(String[] args)
{
     JFrame frame = new JFrame("test");
     JPanel panel = new JPanel();
     int nrOfTextFields = 3;
     JTextField[] textFields = new JTextField[nrOfTextFields];
     int sumOfallTextFields = 0;
     for(int i=0; i<nrOfTextFields; i++)
     {
         final JTextField t = new JTextField();
         t.setColumns(5);
         t.addKeyListener(new KeyListener()
         {
              public void keyReleased(KeyEvent e)
              {
                     sumOfAllTextFields = 0;
                     for(int i=0; i<nrOfTextFields; i++)
                     {
                            int textFieldValue = Integer.parseInt(textFields[i].getString());
                            sumOfAllTextFields += textFieldValue;
                     }
              }
              public void keyTyped(KeyEvent e) {}
             public void keyPressed(KeyEvent e) {}
         });
         panel.add(t);
     }
     JTextField sum = new JTextField();
     sum.setColumns(5);
     panel.add(sum);
     JScrollPane spanel = new JScrollPane(panel);
     frame.add(spanel);
     frame.setSize(800, 600);
     frame.setVisible(true);
 }