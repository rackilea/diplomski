public class Controller extends Thread {

@Override
public void run()
//public void MyShipController(){
    System.out.print("Thread Is started ");
    String CharIn = "";
    while(SpaceInvaders.GameOn = true){
        CharIn = PreControls.ReadKeyPressed.getText();
        if(CharIn.equalsIgnoreCase("a")){
            SpaceInvaders.MyPos[0]--;
                System.out.print("Move Left ");
            }else if(CharIn.equalsIgnoreCase("d")){
                SpaceInvaders.MyPos[0]++;
                System.out.print("Move Right");
            }else if(CharIn.equalsIgnoreCase(" ")){
                //Fire Bullet   
            }
    PreControls.ReadKeyPressed.setText("");
    SpaceInvaders.MyShip.setLocation(SpaceInvaders.MyPos[0], SpaceInvaders.MyPos[1]);
    jp1.repaint();
    }
    }
}