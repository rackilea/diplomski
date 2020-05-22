String TAB_TITLE="Starters";
    Intent intent = new Intent().setClass(this, BLD_IndividualListOfItems_Starters.class);

    Bundle bundle =new Bundle();
    bundle.putString("key_title", TAB_TITLE);
    intent.putExtras(bundle);

    spec = tabHost.newTabSpec("Starters").setIndicator(TAB_TITLE).setContent(intent);
    tabHost.addTab(spec);