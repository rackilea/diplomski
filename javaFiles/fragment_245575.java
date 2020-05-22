public class YourClass extends ProbablySomeClass{
Handler lightsHandler; //The android.os.Handler one, not the java one
Runnable lightsON = new Runnable(){
    @Override
    public void run(){
        if(waiting.isChecked){
            turnLightsOn();
            lightsHandler.postDelayed(lightsOff, 2000);
        }
        else lightsHandler.postDelayed(lightsON, 1000);
    }
}
Runnable lightsOff = new Runnable(){
    @Override
    public void run(){
        turnLightsOff();
        lightsHandler.postDelayed(lightsON, 2000);
    }
}
public YourClass(SomeType someParameter){
init(someParameters);    //Whatever your constructor does
lightsHandler = new Handler();
lightsHandler.post(lightsOn)
}