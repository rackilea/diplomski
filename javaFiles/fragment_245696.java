public class MainClass extends Application {

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {

     ByteBuffer bb = ByteBuffer.allocate(65535); // 65535 is for example, In your code ByteBuffer need to be return by ReadConfigFile.importConfigFile();


        List<Device> devices = UtilClass.createDevices();

        System.out.println(new String(device[0].getCode())); // First device
                                                             // correct
        // here.

        System.out.println(new String(device[0].getCode())); // First device now same
                                                        // as last?
        System.out.println(new String(device[255].getCode()));

        Group root = new Group();

        Scene scene = new Scene(root, 200, 200);
        primaryStage.setTitle("Config File Editor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}