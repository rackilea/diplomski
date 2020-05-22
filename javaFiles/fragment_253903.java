public class HomeWatcher
 {
static final String TAG = "hg";
private Context mContext;
private OnHomePressedListener mListener;
private InnerReceiver mReceiver;

public HomeWatcher(Context context) {
    mContext = context;
}

public void setOnHomePressedListener(OnHomePressedListener listener) {
    mListener = listener;
    mReceiver = new InnerReceiver();
}

public void startWatch() {
    if (mReceiver != null) {
        mContext.registerReceiver(mReceiver, new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS));
    }
}

public void stopWatch() {
    if (mReceiver != null) {
        mContext.unregisterReceiver(mReceiver);
    }
}

private class InnerReceiver extends BroadcastReceiver
{
    final String SYSTEM_DIALOG_REASON_KEY = "reason";
    final String SYSTEM_DIALOG_REASON_GLOBAL_ACTIONS = "globalactions";
    final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";
    final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) {
            String reason = intent.getStringExtra(SYSTEM_DIALOG_REASON_KEY);
            if (reason != null) {
                Log.e(TAG, "action:" + action + ",reason:" + reason);
                if (mListener != null) {
                    if (reason.equals(SYSTEM_DIALOG_REASON_HOME_KEY)) {
                        mListener.onHomePressed();
                    } else if (reason.equals(SYSTEM_DIALOG_REASON_RECENT_APPS)) {
                        mListener.onHomeLongPressed();
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + super.toString();
    }
}

public interface OnHomePressedListener {
    void onHomePressed();
    void onHomeLongPressed();
}