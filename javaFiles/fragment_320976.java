Intent receiverdIntent = getIntent();
        String receivedAction = receiverdIntent.getAction();
        String receivedType = receiverdIntent.getType();

        if (receivedAction.equals(Intent.ACTION_SEND)) {


            Uri receiveUri = (Uri) receiverdIntent
                    .getParcelableExtra(Intent.EXTRA_STREAM);

            if (receiveUri != null) {
                Log.e("Shared",receiveUri.toString());
            }else{
                Log.e("Shared","Nothing");
            }

        }