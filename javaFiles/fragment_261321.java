String mailTo="email@gmail.com";
Intent email_intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",mailTo, null)); 
email_intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject text here"); 
email_intent.putExtra(android.content.Intent.EXTRA_TEXT,"Body text here"); 

startActivity(Intent.createChooser(email_intent, "Send email..."));