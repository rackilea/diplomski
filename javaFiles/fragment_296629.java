package client2;

public class cliententry {

    public static void main(String[] args) {
        client2[] cli = new client2[10];
        for(int i=0; i<10; i++){
            cli[i] = new client2(i);
            cli[i].start();
        }
    }
}