public void actionPerformed(ActionEvent e)
        {
            if(sb.isSelected())
                StudentGUI();
            else if(lb.isSelected())
                System.out.println("Lecturer");
            else if(cdb.isSelected())
                System.out.println("Course Director");
            else if(ab.isSelected())
                System.out.println("Admin");
            yourframe.dispose();//don't know your frame variable
        }



public static void StudentGUI() 
 {
    JFrame frame1 = new JFrame("Input Username");
    frame1.setSize(350, 180);
    frame1.setDefaultCloseOperation(
      JFrame.EXIT_ON_CLOSE);
    frame1.setVisible(true);
     //code omitted
}