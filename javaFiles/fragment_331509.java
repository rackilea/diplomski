private static Patient searchPatientById(int id) {
    Iterator<Patient> it = listPatients.iterator();
    while(it.hasNext()) {
        Patient patient = (Patient) it.next();
        if(patient.getiId() == id)
            return patient;
    }
    // if not found return null
    return null;
}