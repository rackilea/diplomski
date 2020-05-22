private void dashboardOnclick() {
    ListView list = (ListView) findViewById(R.id.dashboardListview);
    list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

        @Override
        public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

            DashboardItems clickedDash = myDash.get(position);
            String message = "You clicked position" + position
                    + "which is" + clickedDash.getItemName();
            Toast.makeText(Dashboard.this, message, Toast.LENGTH_LONG).show();
            Intent intent;
            // i do not know how your dashitems are declared
            // but the idea here is you have already gotten the clicked item so what you do is compare them
           // with the available item you have in your dasboarditem like this
           if(clickedDash ==DashboardItems.Profile){ // assuming DashboardItems.Profile is your profile for profile item
              intent = new Intent(Dashboard.this,UserProfile.class); // you place your intent here in the onitemclick method, in the if equal profile condition
            }else if(clickedDash==DashboardItems.Location){ // you can continue with the others, also here
            // assuming location item is declared in DashboardItems as location
                intent = new Intent(Dashboard.this, UserLocation.class);
              }else{
                // put the 3rd item
              }
            // so it is triggered when you click an item
            startActivity(intent); // then you start it this way
            // that's all you need to do
        }
    });
}