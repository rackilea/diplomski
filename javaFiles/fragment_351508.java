public class SMSSender extends IntentService {

public static final String INTENT_MESSAGE_SENT = "message.sent";
public static final String INTENT_MESSAGE_DELIVERED = "message.delivered";

public static final String EXTRA_MESSAGE = "extra.message";
public static final String EXTRA_RECEIVERS = "extra.receivers";

public SMSSender() {
    super("SMSSender");
}

private final String TAG = "SendSMS";


private static class IDGenerator {

    private static final AtomicInteger counter = new AtomicInteger();

    public static int nextValue() {
        return counter.getAndIncrement();
    }
}

private void sendSMS(String message, String[] receivers) {

    SmsManager sm = SmsManager.getDefault();

    ArrayList<String> parts = sm.divideMessage(message);

    PendingIntent sentPI = null;
    PendingIntent deliveredPI = null;

    Intent sentIntent = new Intent(INTENT_MESSAGE_SENT);

    int sentID = IDGenerator.nextValue();
    sentPI = PendingIntent.getBroadcast(SMSSender.this, sentID, sentIntent,
            PendingIntent.FLAG_CANCEL_CURRENT);

    Intent deliveryIntent = new Intent(INTENT_MESSAGE_DELIVERED);

    int deliveredID = IDGenerator.nextValue();
    deliveredPI = PendingIntent.getBroadcast(SMSSender.this, deliveredID,
            deliveryIntent, PendingIntent.FLAG_CANCEL_CURRENT);

    Log.i(TAG, "sending SMS: parts: " + parts.size() + " message: "
            + message);

    if (parts.size() > 1) {
        ArrayList<PendingIntent> sentIntents = null;
        ArrayList<PendingIntent> deliveredIntents = null;

        sentIntents = new ArrayList<PendingIntent>();
        deliveredIntents = new ArrayList<PendingIntent>();

        for (int i = 0; i < parts.size(); i++) {
            sentIntents.add(sentPI);
            deliveredIntents.add(deliveredPI);
        }

        for (String receiver : receivers) {
            try {
                sm.sendMultipartTextMessage(receiver, null, parts,
                        sentIntents, deliveredIntents);
            } catch (IllegalArgumentException e) {
                Log.e(TAG, "illegal receiver: " + receiver);
            }

        }
    } else {
        for (String receiver : receivers) {
            try {
                sm.sendTextMessage(receiver, null, parts.get(0), sentPI,
                        deliveredPI);
            } catch (IllegalArgumentException e) {
                Log.e(TAG, "illegal receiver: " + receiver);
            }
        }
    }
}

@Override
protected void onHandleIntent(Intent intent) {
    String message = intent.getStringExtra(EXTRA_MESSAGE);
    String[] receivers = intent.getStringArrayExtra(EXTRA_RECEIVERS);

    sendSMS(message, receivers);

}