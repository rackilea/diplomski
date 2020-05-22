@Override
            public void onClick(View v) {

//                    Toast.makeText(MainActivity.this,
//                            "OnClickListener : " +
//                                    "\nSpinner 1 : " + String.valueOf(routeChoice.getSelectedItem()),
//                            Toast.LENGTH_SHORT).show();

                     Intent intent = new Intent(MainActivity.this, BusTrackingActivity.class);
                     startActivity(intent);

            }