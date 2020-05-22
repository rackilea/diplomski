// From activity1 to activity2
    Intent intent = new Intent(Activity1.this, Activity2.class);
    Bundle bundle = new Bundle();
    bundle.putString(<key>, <value>);
    intent.putExtras(bundle);
    startActivity(intent);

    // in activity 2 onCreate
    Bundle bundle = intent.getExtras();
    if (bundle != null) {
        // get the value from bundle based on key
    }