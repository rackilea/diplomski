Intent intentShare = new Intent(Intent.ACTION_SEND);
        intentShare.putExtra(intentShare.EXTRA_STREAM, imageURI);
        intentShare.setType("image/*");
        intentShare.putExtra(Intent.EXTRA_TEXT, "The sms body goes here");
        if (intentShare.resolveActivity(getPackageManager()) != null) {
            startActivity(intentShare);
        }