@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.badge_menu, menu);
    MenuItem item = menu.findItem(R.id.myswitch);
    MenuItemCompat.setActionView(item, R.layout.switch_layout);
    RelativeLayout notifCount = (RelativeLayout) MenuItemCompat.getActionView(item)

    Switch switch_button = (Switch) notifCount.findViewById(R.id.switchForActionBar);

    switch_button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // do something, the isChecked will be
            // true if the switch is in the On position
        }
    });
    return super.onCreateOptionsMenu(menu);
}