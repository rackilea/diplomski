private void startMessageServiceIntent(String message, String receiver) {
        Intent i = new Intent(context, SMSSender.class);
        i.putExtra(SMSSender.EXTRA_MESSAGE, message);
        i.putExtra(SMSSender.EXTRA_RECEIVERS, new String[] { receiver });
        startService(i)
    }