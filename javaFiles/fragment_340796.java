DataReceivedListener listener;

public void setDataReceivedListener(DataReceivedListener listener) {
    this.listener = listener;
}

public interface DataReceivedListener {
    void onReceived(int requestCode, int resultCode, Intent data)
}