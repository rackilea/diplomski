val receiver = ComponentName(this, SmsReceiver::class.java!!) //created SMSLog class above!
    val pm = this.packageManager

    pm.setComponentEnabledSetting(receiver,
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP)

try {
        this.registerReceiver(smsReceiver, android.content.IntentFilter("android.provider.Telephony.SMS_RECEIVED"))
    } catch (e: Exception) {
    }