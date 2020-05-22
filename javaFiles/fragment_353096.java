@Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch(v.getId()){

            case R.id.apptSave:

       String getNewDate = date.toString();
       String getNewTitle = nameTextBox.getText().toString();
       String getNewTime = timeTextBox.getText().toString();
       String getNewDetails = detailsTextBox.getText().toString();

                DBHandler db = new DBHandler(this);
                db.addAppointment(new Appointment(getNewID.getID(), getNewDate, getNewTitle, getNewTime, getNewDetails));
                finish();
                break;
            }
        }