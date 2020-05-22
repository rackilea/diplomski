public class StayOpenPopup extends JPopupMenu{
    public void setVisible(boolean visible){
        if(visible == true)
            super.setVisible(visible);
    }

    public void disappear() {
        super.setVisible(false);
    }
}