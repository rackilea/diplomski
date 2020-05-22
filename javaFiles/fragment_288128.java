public class MyServer {
    private AtomicBoolean keepServerOn = new AtomicBoolean(true);

    public void setKeepServerOff() {
        keepServerOn.set(false);
    }

    public void shouldKeepGoing() {
        return keepServerOn.get();
    }

    public static void main(Strings[] args) {
    ....// where you accept clients and create TestResponse
    MyServer myServer = new MyServer();
    ...// somewhere new TestResponse(socket, myServer);
    }
}


public class testReponse implements Runnable {
private MyServer server;
private Socket socket;
private AtomicBoolean keepServerOn = new AtomicBoolean(true);

public testReponse(Socket socket2, MyServer server){
        socket = socket2;
}

@Override
public void run() {
    BufferedReader in = null;
    PrintWriter out = null;

    try {
        in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream());

        while(server.shouldKeepGoing()){
            String reponse = in.readLine();
            System.out.println("Reponse : "+ reponse);

            if(reponse.equals("right")){    
                server.setKeepServerOff();
                out.println("correct");
                out.flush();
            } else {
                out.println("incorrect");
                out.flush();
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if(in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(out!= null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}