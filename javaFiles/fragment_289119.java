public class ResponseReceiver extends BroadcastReceiver
    {
        public static final String m_broadcastKey = "Uz258e3wZm77Z3Tdebn7PqgW3CLBJ8";

        public void onReceive(Context context, Intent intent)
        {
            String response = intent.getStringExtra("response");

            clear();

            ((TextView) m_widgets.get("text")).setText("Finally found someone !" + response);
            show(m_widgets.get("text"));

            ((Button) m_widgets.get("button1")).setText("OK let's do this !");
            show(m_widgets.get("button1"));

            ((Button) m_widgets.get("button2")).setText("Later ?");
            show(m_widgets.get("button2"));

            unregisterReceiver(m_receiver);
        }
    }