override fun onReceive(context: Context, intent: Intent) {
    val data = intent.extras
    if (data!!.get("pdus") != null) {
        val pdus = data!!.get("pdus") as Array<Any>

        for (i in pdus.indices) {
            val smsMessage = SmsMessage.createFromPdu(pdus[i] as ByteArray)
            val sender = smsMessage.displayOriginatingAddress
            val messageBody = smsMessage.messageBody
            if (messageBody.toLowerCase().contains("please use the verification code", ignoreCase = true)) {
                try {
                    mListener!!.messageReceived(parseCode(messageBody))
                }catch (e:NullPointerException)
                {
                }
            }
        }
    }
}