Intent email = new Intent(Intent.ACTION_SEND);
    email.putExtra(Intent.EXTRA_EMAIL, new String[]{"youremail@yahoo.com"});          
    email.putExtra(Intent.EXTRA_SUBJECT, "subject");
    email.putExtra(Intent.EXTRA_TEXT, "message");
    email.setType("message/rfc822");
    startActivity(Intent.createChooser(email, "Choose an Email client :"));