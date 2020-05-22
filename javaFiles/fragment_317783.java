public static void main(String[] args)
{
    // Creating a frame
    JFrame frame = new JFrame("Example");
    // Setting the position and the size of the frame
    frame.setBounds(0,0,800,600);
    // This will terminate the program when closing the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Then you can display your frame
    frame.setVisible(true);
}