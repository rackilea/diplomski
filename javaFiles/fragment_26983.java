textviewFrom.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

             showFromDatePicker(fromdateListener, calFromDate, calToDate);
        }
    });
textviewTo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            showToDatePicker(todateListener, calToDate, calFromDate);
        }
    });