public class Test
{

    public static void main (String[] args)
    {

        JFrame f1 = new JFrame();
        f1. setSize(100, 100);
        f1.setLocationRelativeTo(null);
        f1.setVisible(true);

        JFrame f2 = new JFrame();
        f2.setSize(100, 100);
        f2.setLocation(f1.getX() + f1.getWidth(), f1.getY());
        f2.setVisible(true);

    }

}