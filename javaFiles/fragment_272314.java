tabHost.addTab(tabHost.newTabSpec("tab1")
        .setIndicator("First Text")
        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        .setContent(new Intent(this, class1.class)));
 tabHost.addTab(tabHost.newTabSpec("tab2")
        .setIndicator("Second Text")
        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        .setContent(new Intent(this, class2.class)));