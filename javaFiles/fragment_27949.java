public class Client extends Application{

    Thread send;
    Thread accept;
    DatagramPacket pack;
    DatagramSocket sock;
    private List<String> str;
    String name, sname;
    int listeningPort;
    InetAddress server_ip;
    String sender;

    public Parent createContent(){
        ScrollPane sp = new ScrollPane();
        TextFlow textFlow = new TextFlow();
        textFlow.setPadding(new Insets(10));
        textFlow.setLineSpacing(10);
        TextField textField = new TextField();
        textField.setPrefSize(50,30);
        Button button = new Button("Send");
        button.setPrefSize(80,30);
        Button button2 = new Button("Start");
        button2.setPrefSize(50,30);
        VBox container = new VBox();
        VBox box = new VBox();
        box.getChildren().addAll(sp,textFlow);
        container.setPadding(new Insets(10));
        container.getChildren().addAll(box, new HBox(textField, button,button2));
        VBox.setVgrow(sp, Priority.ALWAYS);
        VBox.setVgrow(textFlow, Priority.ALWAYS);
        return container;
    }

    public void playSound() {
        String gongFile =  "C:\\Users\\HP\\IdeaProjects\\FirstGUI\\src\\sample\\Really\\Small-bell-jingling.wav";
        InputStream in = null;
        try {
            in = new FileInputStream(gongFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        AudioPlayer.player.start(audioStream);
    }
    public void start(Stage stage) throws Exception {

        str=getParameters().getRaw();

        name = str.get(0);
        listeningPort = Integer.parseInt(str.get(1));
        server_ip = InetAddress.getByName(str.get(2));
        sname = str.get(3);
        sock = new DatagramSocket();
        byte[] data = new byte[1024];
        data = String.valueOf(str2).getBytes();
        pack = new DatagramPacket(data, data.length, server_ip, 5050);
        sock.send(pack);

        send = new Thread() {

            public void run() {
                DatagramSocket sock = null;
                try {
                    sock = new DatagramSocket();
                } catch (SocketException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
                while (true) {
                    InetAddress host = server_ip;
                    try {
                        Scanner input = new Scanner(System.in);
                        String in = input.nextLine();
                        byte[] data = new byte[1024];
                        data = String.valueOf(str).getBytes();
                        DatagramPacket sendPack = new DatagramPacket(data, data.length);
                        sendPack.setPort(5050);
                        sendPack.setAddress(host);
                        sock.send(sendPack);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }

        };
        send.start();
        accept = new Thread() {

            public void run() {
                try {
                    sock = new DatagramSocket(listeningPort);
                } catch (SocketException e) {
                    e.printStackTrace();
                }
                while (true) {
                    byte[] data = new byte[1000];
                    pack = new DatagramPacket(data, data.length);
                    try {
                        sock.receive(pack);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String incoming = null;
                    try {
                        incoming = new String(data, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    System.out.println(incoming);

                }
            }
        };

        accept.start();
        Parent p=createContent();
        Scene scene = new Scene(p, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Chit-Chat");
        stage.show();
    }


    public static void main(String[] args) throws IOException {
        launch(args);
    }

}