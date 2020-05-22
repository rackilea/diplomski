public class something implements MouseMotionListener{    

      public something(){
        button.addMouseMotionListener(this);
        frame.addMouseMotionListener(this);
        panel.addMouseMotionListener(this);
        JTextField.addMouseMotionListener(this);          
      }   

//MouseMotionListener methods

     @Override
     public void mouseDragged(MouseEvent e) {    
        // TODO Auto-generated method stub          
    }

    @Override
    public void mouseMoved(MouseEvent e) {    
        // TODO Auto-generated method stub          
    }     
}