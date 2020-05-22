calenderView.setOnDateSelectedListener(new OnDateSelectedListener() {

            @Override
            public void onDateUnselected(Date date) {

            }

            @Override
            public void onDateSelected(Date date) {

            Toast.makeText(HomeActivity.this,calenderView.getSelectedDate().getTime()+"", Toast.LENGTH_LONG).show();            

            tv.setText("Pickup Date:" +calenderView.getSelectedDate().getTime());
                }
            });