class PhoneStateReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {

        prefs = context.getSharedPreferences(PREFS_FILENAME, 0)
        val record_calls = prefs!!.getBoolean("recordCalls", false)
        val service = Intent(context, AudioService::class.java)

        val state = intent.getStringExtra(TelephonyManager.EXTRA_STATE)
        val incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)

        when(state){
            TelephonyManager.EXTRA_STATE_RINGING -> {
                      //      Toast.makeText(context, "Ringing $incomingNumber", Toast.LENGTH_LONG).show()
                            }
            TelephonyManager.EXTRA_STATE_OFFHOOK -> {
               // Toast.makeText(context, "IS_SERVICE_RUNNING $IS_SERVICE_RUNNING", Toast.LENGTH_LONG).show()
                            if (record_calls) {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    context.startForegroundService(service)
                                } else context.startService(service)
                                IS_SERVICE_RUNNING = true
                                }
            }
            TelephonyManager.EXTRA_STATE_IDLE -> if (IS_SERVICE_RUNNING) context.stopService(service)
            else -> Toast.makeText(context, "ERROR", Toast.LENGTH_LONG).show()
        }
    }
}