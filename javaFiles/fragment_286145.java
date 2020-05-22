public void addListenerOnButton() {
    dadclink = (Button) findViewById(R.id.dadclink);
    dadclink.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = newInstagramProfileIntent(getPackageManager(),
                    "your_string_url");

            // do something with the intent, perhaps starting an activity
            startActivity(intent);
        }
    });
}

public static Intent newInstagramProfileIntent(PackageManager pm, String url) {
    Intent intent = new Intent(Intent.ACTION_VIEW);
    try {
        if (pm.getPackageInfo("com.instagram.android", 0) != null) {
            if (url.endsWith("/")) {
                url = url.substring(0, url.length() - 1);
            }

            String natgeo = url.substring(url.lastIndexOf("/") + 1);
            intent.setData(Uri.parse("http://instagram.com/_u/" + natgeo));
            intent.setPackage("com.instagram.android");
            return intent;
        }
    } catch (NameNotFoundException e) {
        e.printStackTrace();
    }

    intent.setData(Uri.parse(url));
    return intent;
}