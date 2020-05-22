public class MyDemo {

    private static Client client;
    private static String DEVICE_NAME = "";
    private static String DATA_SET = "";

    public static void main(String[] args) {

        try {

            startRedRat();

            client = new Client();
            client.openSocket("localhost", 40000);

            DEVICE_NAME = client.readData("hubquery=\"list redrats\"").split("]")[1].split("\n")[0].trim();
            DATA_SET = client.readData("hubquery=\"list datasets\"").split("\n")[1];

            sendCommand("power");
            TimeUnit.SECONDS.sleep(5);

            sendCommand("btn1", "btn1", "btn1", "btn1");
            sendCommand("btnOK");
            TimeUnit.SECONDS.sleep(30);
            sendCommand("btnBACK");
            sendCommand("channel+");
            sendCommand("btn6", "btn1");
            sendCommand("channel+");
            sendCommand("channel-");
            sendCommand("volume+");
            sendCommand("volume-");
            sendCommand("power");

            client.closeSocket();

            p.destroy();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            System.out.println("Finished. Hit <RETURN> to exit...");
        }
    }


    private static void sendCommand(String... command) {

        try {
            for (String cmd : command) {
                client.sendMessage("name=\"" + DEVICE_NAME + "\" dataset=\"" + DATA_SET + "\" signal=\"" + cmd + "\"");
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(cmd + " signal send");
            }
            TimeUnit.SECONDS.sleep(3);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void startRedRat() {
        try {
            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    p = Runtime.getRuntime().exec("cmd /C C:\\RedRatHub\\RedRatHubCmd.exe C:\\RedRatHub\\TivibuDB.xml");
                    return null;
                }
            };
            worker.run();
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}