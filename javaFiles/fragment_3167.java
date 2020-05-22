public class Test extends JFrame{
    public static void main(String[] args){
        JFrame frame = new JFrame();
        MyPanel myPanel = new MyPanel();
        frame.add(myPanel);

        frame.pack();
        frame.setVisible(true);
    }

}

class MyPanel extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        g.drawLine(10, 10, 100, 100);
    }
}