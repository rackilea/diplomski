public class A2 extends MouseAdapter{
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        System.out.println("2");
        if((screen ==0) && start2.contains(mx,my)){
            screen=1;
            System.out.println("1");
        }
    }
    public void mouseClicked(MouseEvent e) {

    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

    }
    public void mouseReleased(MouseEvent e) {

    }
}