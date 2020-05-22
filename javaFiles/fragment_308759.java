/* SmartApp.java */
public class SmartApp extends Activity 
{
    private ConnectDevice cD = new ConnectDevice();
    private DataRobot dR = new DataRobot();
    private DataBuilder dB = new DataBuilder();
    private DataSender dS = new DataSender();
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.intro);

    cD.addDataReceivedListener(new DataReceivedListener() {
        @Override
        public void dataReceivedReceived(DataReceivedEvent event) {
            // TODO Auto-generated method stub
            dR.analyzeData(event.getData());
        }
    });
    dR.addDataAnalyzedListener(new DataAnalyzedListener() {
        @Override
        public void dataAnalyzedReceived(DataAnalyzedEvent event) {
            // TODO Auto-generated method stub
            dB.submitData(event.getData());
        }
    });
    dB.addDataBuilderListener(new DataBuilderListener() {
        @Override
        public void dataBuilderReceived(DataBuilderEvent event) {
            // TODO Auto-generated method stub
            dS.sendData(event.getData());
        }
    });
      }
}