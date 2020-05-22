public class SimpleThread extends Thread{   
static int x=0;
@Override
public void run(){
    for (int i = 0; i < 50; i++) {
        System.out.println(x+" "+i+" "+getName());
        try{
            x++;
            sleep((int)(Math.random()*1000));
        } catch (InterruptedException ex) {
            System.out.println("Sucedió un error");
        }
    }
    System.out.println("Hecho! "+getName());
}