@Override
        public void onClick(View v) {
            // TODO Auto-generated method stub  
            firstName.setText(currentPatient.getName());
            name.setText(currentPatient.getFirstName());
            patientID.setText(currentPatient.getId());
            minH.setText(currentPatient.getNumHeartRateMin());
            maxH.setText(currentPatient.getNumHeartRateMax());
            minI.setText(currentPatient.getNumInterBeatIntervalMin());
            maxI.setText(currentPatient.getNumInterBeatIntervalMax());
            minB.setText(currentPatient.getNumBreathingrateMin());
            maxB.setText(currentPatient.getNumBreathingrateMax());
            updateDetails(patient);

        }