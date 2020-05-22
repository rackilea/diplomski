updateButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Logic goes here.
           onUpdateClick(position, alarmList); // public method in adapter
        }
    });