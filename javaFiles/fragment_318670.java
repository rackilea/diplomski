// Create a chooser for things that can ACTION_SEND images
    Intent intent = new Intent(Intent.ACTION_SEND);
    Uri data = Uri.parse("content://media/external/images/media/98");
    intent.putExtra(Intent.EXTRA_STREAM, data);
    intent.setType("image/jpeg");
    Intent chooser = Intent.createChooser(intent, "Blah");

    // Add the stupid HTC-Sense-specific secondary intent
    Intent htcIntent = new Intent("android.intent.action.SEND_MSG");
    htcIntent.putExtra(Intent.EXTRA_STREAM, data);
    htcIntent.setType("image/jpeg");  
    chooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] { htcIntent });

    // Show the chooser
    startActivity(chooser);