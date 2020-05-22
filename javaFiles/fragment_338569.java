public class Canvas extends JPanel implements MouseListener{
    private Rectangle rect = new Rectangle(100,100);

    public Canvas(){
        this.addMouseListener(this);
        rect.setSize(100, 100);
    }

    @Override
    public void paintComponent(Graphics g){
        g.setClip(rect);
        g.setColor(Color.RED);
        g.fillRect(0, 0, 100, 100);
    }

    @Override
    public void mouseClicked(MouseEvent e){
        if(rect.contains(e.getPoint())){
            JOptionPane.showConfirmDialog(this, "Click!");
        }
    }

    // The rest of the MouseListener methods have been cut out

    public static void main(String[] a){
        JFrame frame = new JFrame("Canvas Thingy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 300, 300);
        frame.add(new Canvas());
        frame.setVisible(true);
    }
}