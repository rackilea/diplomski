public class MainController{

    private Controller1 controller1;
    private Controller2 controller2;
    private Controller3 controller3;

    public MainController(){
        controller1=new Controller1();            
        controller2=new Controller2();           
        controller3=new Controller3();

        addListeners();
    }

    private class Ctrl1Listener implements Controller1Listener(){        
        public void controller1ActionPerformed(Controller1Event e){
            //Calls the method of view3     
            controller3.update();
        }
    }

    private class Ctrl2Listener implements Controller2Listener(){           
        public void controller2ActionPerformed(Controller2Event e){
            //Calls the method of view3     
            controller3.update();
        }
    }

    private void addListeners(){
        controller1.addListener(new Ctrl1Listener());
        controller2.addListener(new Ctrl2Listener());
    }
}