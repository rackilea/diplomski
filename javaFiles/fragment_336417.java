receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                workingWithBtn(intent.extras.getInt("url"))
            }
        }
registerReceiver(receiver, filter)