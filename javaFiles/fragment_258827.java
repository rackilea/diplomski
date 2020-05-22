public class MasterApplet extends JApplet {

private int index = 0;
private JApplet[] applets;

public void init(){
    JApplet appletA = new AppletA();
    JApplet appletB = new AppletB();
    applets = new JApplet[]{appletA, appletB};
    setViewing(index);
}

public void paint(Graphics g){
    applets[index].paint(g);
}

public void setViewing(int idex){
    index = idex;
    applets[idex].init();
    revalidate();
    repaint();
}