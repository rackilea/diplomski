public class cityListener extends MouseAdapter{
    public void mouseClicked(MouseEvent e){
       City current=(City)e.getSource();

               if(current.active==false)
                  current.clicked(true);
              else if(current.active==true)
                  current.clicked(false);
    }
}