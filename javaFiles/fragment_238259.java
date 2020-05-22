private boolean isChecked = true;
final BroadcastReceiver sendSMS = new BroadcastReceiver() {
                @Override
                public void onReceive(Context arg0, Intent arg1) {
                    while(isChecked == true){
                    switch (getResultCode()) {
                        case Activity.RESULT_OK:
                            break;
                        case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                            Toast.makeText(getContext(), "Generic failure",
                                    Toast.LENGTH_SHORT).show();
                            isChecked = false;
                            break;
                        case SmsManager.RESULT_ERROR_NO_SERVICE:
                            Toast.makeText(getContext(), "No service",
                                    Toast.LENGTH_SHORT).show();
                            isChecked = false;
                            break;
                        case SmsManager.RESULT_ERROR_NULL_PDU:
                            Toast.makeText(getContext(), "Null PDU",
                                    Toast.LENGTH_SHORT).show();
                            isChecked = false;
                            break;
                        case SmsManager.RESULT_ERROR_RADIO_OFF:
                            Toast.makeText(getContext(), "Radio off",
                                    Toast.LENGTH_SHORT).show();
                            isChecked = false;
                            break;
                    }
                    }
                }
            };