Preference Email;

Email = (Preference) this.findPreference("email");
Email.setOnPreferenceClickListener(new OnPreferenceClickListener() {
    @Override
    public boolean onPreferenceClick(Preference preference) {
        // Informazioni sul telefono
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;

        //**EDITED**
        String STR_EMAIL_BODY = "Manufacturer: "+manufacturer + "\nModel: " + model;

        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        String[] recipients = new String[]{"" , "EMAIL@gmail.com"};
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, recipients);
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "" );
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, STR_EMAIL_BODY);
        //**EDITED**
        intent.setType("text/html");
        startActivity(Intent.createChooser(emailIntent, "Send Email"));
        return false;
    }
});