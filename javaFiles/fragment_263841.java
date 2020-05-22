public static void main(String args[])
{
    Buffer oval = new Buffer();
    oval.setBackground(Color.RED);

    JFrame frame=new JFrame();
    frame.add( oval );
    frame.setSize(500,500);
    frame.setVisible(true);
}