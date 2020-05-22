int mRingerMode;

Toast.makeText(getApplicationContext(), "INCOMING CALL", Toast.LENGTH_SHORT).show();

if(state == TelephonyManager.CALL_STATE_RINGING)
{
    Toast.makeText(getApplicationContext(), "Inside", Toast.LENGTH_SHORT).show();

    if(incomingNumber != null)
    {
        mRingerMode = audioManager.getRingerMode();
                        audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                HashMap<String, String> myHashRender = new HashMap<String, String>();
                myHashRender.put(TextToSpeech.Engine.KEY_PARAM_STREAM, 
                        String.valueOf(AudioManager.STREAM_VOICE_CALL));
                tts.speak(incomingNumber, TextToSpeech.QUEUE_FLUSH, myHashRender);
            }
        }).start();

        Toast.makeText(getApplicationContext(), "speak number", Toast.LENGTH_SHORT).show();
    }


    if(state == TelephonyManager.CALL_STATE_IDLE)
    {
        audioManager.setRingerMode(mRingerMode);
    }
}