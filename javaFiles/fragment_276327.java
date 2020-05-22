public class City extends JComponent{
    private boolean active=false;
    protected int x;
    private int y;
    public City(int x, int y){
        setBounds(x, y, 20, 20);
        setPreferredSize(new Dimension(20,20));
        setMaximumSize(new Dimension(20,20));
        setMinimumSize(new Dimension(20,20));
    }
protected void paintComponent(Graphics g){
    super.paintComponent(g);
        if(active==true)
            active(g);

        else if(active==true)
            notActive(g);
    }


public void active(Graphics g){
    g.setColor(Color.RED);
    g.fillRect(0,0,getWidth(),getHeight());
}

public void notActive(Graphics g){
    g.setColor(Color.BLUE);
    g.fillRect(0, 0, getWidth(),getHeight());
}
public boolean clicked(boolean b){
active=b;
repaint();  //repaint whenever the flag active changes
}
public boolean isActive(){
   return active;
}