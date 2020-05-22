public class CallManager {
    private static final String TAG = CallManager.class.getSimpleName();
    private AudioManager audioManager;
    private Context context;

    public CallManager(Context context) {
        this.context = context;
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    }

    public void acceptCall() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                TelecomManager telecomManager = (TelecomManager) context.getSystemService(Context.TELECOM_SERVICE);
                if (telecomManager != null) {
                    telecomManager.acceptRingingCall();
                }
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                throughMediaController(context);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                throughAudioManager();
            }
        } catch (Exception e) {
            throughReceiver(context);
        }
    }

    private ITelephony getTelephonyService(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        try {
            Class c = Class.forName(tm.getClass().getName());
            Method m = c.getDeclaredMethod("getITelephony");
            m.setAccessible(true);
            return (ITelephony) m.invoke(tm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void throughTelephonyService(Context context) {
        ITelephony telephonyService = getTelephonyService(context);
        if (telephonyService != null) {
            telephonyService.silenceRinger();
            telephonyService.answerRingingCall();
        }
    }

    private void throughAudioManager() {
        KeyEvent downEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_HEADSETHOOK);
        KeyEvent upEvent = new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_HEADSETHOOK);
        audioManager.dispatchMediaKeyEvent(downEvent);
        audioManager.dispatchMediaKeyEvent(upEvent);
    }

    private void throughReceiver(Context context) {
        try {
            throughTelephonyService(context);
        } catch (Exception exception) {
            boolean broadcastConnected = "HTC".equalsIgnoreCase(Build.MANUFACTURER)
                    && !audioManager.isWiredHeadsetOn();

            if (broadcastConnected) {
                broadcastHeadsetConnected(false, context);
            }
            try {
                Runtime.getRuntime().exec("input keyevent " + KeyEvent.KEYCODE_HEADSETHOOK);
            } catch (IOException ioe) {
                throughPhoneHeadsetHook(context);
            } finally {
                if (broadcastConnected) {
                    broadcastHeadsetConnected(false, context);
                }
            }
        }
    }

    private void broadcastHeadsetConnected(boolean connected, Context context) {
        Intent intent = new Intent(Intent.ACTION_HEADSET_PLUG);
        intent.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY);
        intent.putExtra("state", connected ? 1 : 0);
        intent.putExtra("name", "mysms");
        try {
            context.sendOrderedBroadcast(intent, null);
        } catch (Exception e) {
        }
    }

    private void throughMediaController(Context context) {
        MediaSessionManager mediaSessionManager = (MediaSessionManager) context.getSystemService(Context.MEDIA_SESSION_SERVICE);
        try {
            List<MediaController> controllers = mediaSessionManager.getActiveSessions(new ComponentName(context, NotificationService.class));
            for (MediaController controller : controllers) {
                if ("com.android.server.telecom".equals(controller.getPackageName())) {
                    controller.dispatchMediaButtonEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_HEADSETHOOK));
                    break;
                }
            }
        } catch (Exception e) {
            throughAudioManager();
        }
    }

    private void throughPhoneHeadsetHook(Context context) {
        Intent buttonDown = new Intent(Intent.ACTION_MEDIA_BUTTON);
        buttonDown.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_HEADSETHOOK));
        context.sendOrderedBroadcast(buttonDown, "android.permission.CALL_PRIVILEGED");

        Intent buttonUp = new Intent(Intent.ACTION_MEDIA_BUTTON);
        buttonUp.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_HEADSETHOOK));
        context.sendOrderedBroadcast(buttonUp, "android.permission.CALL_PRIVILEGED");
    }
}