Intent i = new Intent(Intent.ACTION_SEND);
i.setType("text/plain");
i.putExtra(Intent.EXTRA_EMAIL, new String[] { "myemail@example.com" });
i.putExtra(Intent.EXTRA_SUBJECT, "Adding new shop to MinuteMap");
i.putExtra(Intent.EXTRA_TEXT, "nll"); 
startActivity(i);