override fun onStop() {//
    super.onStop()
    try {
        unregisterReceiver(smsReceiver)
    } catch (e: Exception) {

    }
    disableBroadcastReceiver()
}