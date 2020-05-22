class playerTask implements Runnable{

public audio mic_player = new audio(); //The audio class we declared above
private Thread t;

public playerTask(){

}
public void execTask(){

    t = new Thread(this,"playing_Thread");
    t.start();

}
public void abortTask(){

    mic_player.stop();
}

public void run(){
    mic_player.run();

}