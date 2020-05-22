@FXML
private TextField txt;
@FXML
private Button bt;
@FXML
private AnchorPane anc; 
@FXML
private WebView webView;

long startTime, endTime, duration;
int startRecording = 0;//This helps you to not try to get the duration the first time the button is pressed.