// Client.java
public class Client {

    public static void main(String[] args) {

        String host;
        if (args.length > 0)
            host = args[0];
        else
            host = "localhost";

        int port;
        if (args.length > 1)
            port = Integer.parseInt(args[1]);
        else
            port = 4444;

        try (Socket socket = new Socket(host, port);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            Thread input = new Thread(() -> {
                String msg;
                try {
                    while ((msg = in.readLine()) != null) {
                        System.out.println(msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            input.start();

            String userName = "User" + ((int) (Math.random() * 200));
            String msg;
            try {
                while ((msg = stdIn.readLine()) != null) {
                    for (int i = 0; i < msg.length(); i++)
                        System.out.print("\b");
                    out.write(userName + ": " + msg + "\n");
                    out.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}