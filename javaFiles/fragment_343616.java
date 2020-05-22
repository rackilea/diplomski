@Override
public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    Application.Parameters parameters = getParameters();
    List<String> rawParams = parameters.getRaw();
    String userName = rawParams.get(0);
    String password = rawParams.get(1);
    String host = rawParams.get(2);
    this.shell = new Shell(username,password,host);
    initialiseOverview();
}