public class Principal{

private boolean bo1;
private Thread tr1;


public Principal(){

    bo1 = true;
    tr1 = new Thread(){
        public void run(){
            while(bo1){
                //What the Thread does goes here, its a chronometer.
            }          
        }
    };  // The thread body stops here.
}   // The constructor body stops here. 
public void stopThread(){
    changeBo1();
    tr1.join();
}
public void changeBo1(){
        bo1 = !bo1;
} //Change bo1 ends here.
} //Class ends here.