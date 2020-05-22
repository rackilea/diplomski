String recipientEmail = null;
Bundle extras = getIntent().getExtras();
if(extras == null) {
    throw new IllegalStateException("No email address found at SendMail activity!");
} else {
    recipientEmail = extras.getString("RECIPIENT_EMAIL");
}