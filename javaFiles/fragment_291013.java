public static void sendAsMail(File file, Context econtext) {
    try {
        final Intent emailIntent = new Intent(
                android.content.Intent.ACTION_SEND);
        emailIntent.setType("text/*");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                new String[] { "" });
        emailIntent.putExtra(android.content.Intent.EXTRA_CC,
                new String[] {});
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                "FROM Sample");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "HI");
        emailIntent.putExtra(android.content.Intent.EXTRA_STREAM,
                Uri.parse(file.toURI().toString()));
        mContext.startActivity(emailIntent);
    } catch (Exception e) {
    }
}