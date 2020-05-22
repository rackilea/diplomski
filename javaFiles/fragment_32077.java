nameET=firstName.getText().toString();
    firstNameET=name.getText().toString();
    pIDET=patientID.getText().toString();
    minHET=minH.getText().toString();
    maxHET= maxH.getText().toString();
    minIET= minI.getText().toString();
    maxIET=maxI.getText().toString();
    minBET=minB.getText().toString();
    maxBET=maxB.getText().toString();


    patient.setName(nameET);
    patient.setFirstName(firstNameET);
    patient.setId(pIDET);
    patient.setNumHeartRateMin(minHET);
    patient.setNumHeartRateMax(maxHET);
    patient.setNumInterBeatIntervalMin(minIET);
    patient.setNumInterBeatIntervalMax(maxIET);
    patient.setNumBreathingrateMin(minBET);
    patient.setNumBreathingrateMax(maxBET);
    insertData(patient);