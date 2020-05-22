try {
        val intent = Intent()
        intent.action = CALL_ACTION
        val pendingIntent = PendingIntent.getBroadcast(mContext?.applicationContext, 0, intent, Intent.FILL_IN_DATA)
        sipManager?.open(sipProfile, pendingIntent, null)
        sipManager?.setRegistrationListener(sipProfile!!.uriString,
                object : SipRegistrationListener {
                    override fun onRegistering(localProfileUri: String) {
                        Log.e(TAG, "onRegistering $localProfileUri")
                    }

                    override fun onRegistrationDone(localProfileUri: String, expiryTime: Long) {
                        Log.e(TAG, "onRegistrationDone $localProfileUri expiryTime=$expiryTime")
                    }

                    override fun onRegistrationFailed(localProfileUri: String, errorCode: Int, errorMessage: String) {
                        Log.e(TAG, "onRegistrationFailed $localProfileUri $errorMessage $errorCode")
                    }
                })
    } catch (pe: ParseException) {
        Log.e(TAG, pe.message!!)
    } catch (se: SipException) {
        Log.e(TAG, se.message!!)
        if (!sipManager?.isOpened(sipProfile?.uriString)!!) {
            //Just sent a toast to restart the device 
            Toast.makeText(this, "SIP Error - Please Restart Device and Try Again", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, se.message, Toast.LENGTH_SHORT).show()
        }
    }