package server2;

public class serverentry {

    public static void main(String[] args) {
        server[] serv = new server[10];
        for (int i=0; i<10; i++){
            serv[i] = new server(12345+i);
            serv[i].start();
        }
    }
}