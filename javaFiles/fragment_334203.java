// Launching new Activity on selecting single List Item
        Intent in = new Intent(MainActivity.this, SingleContactActivity.class);

           // sending data to new activity
        in.putExtra("TAG_NAME", "Name is passed here!");
        in.putExtra(TAG_EMAIL, cost);
        in.putExtra(TAG_PHONE_MOBILE, description);
        startActivity(in);