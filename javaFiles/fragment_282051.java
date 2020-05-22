public class BleConnectorFactory{

    public static BleConnector getBleConnector() {

        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return new BleConnect21Api();
        }else{
            return new BleConnectOldApi();
        }

    }
}