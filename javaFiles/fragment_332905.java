//AlarmAlertBroadcastReceiver.java

@Override
public void onReceive(Context context, Intent intent) {
   ByteArrayInputStream bis = new ByteArrayInputStream(intent.getByteArrayExtra("alarm"));
    ObjectInput in = null;
    Alarm alarm = null;
    try {
        in = new ObjectInputStream(bis);
        alarm = (Alarm)in.readObject();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}