public Patient getPatientByID(String id) {
    for (Patient patient : patientList1) {
        if (patient.getID().equals(id)) {
            return patient;
        }
    }
}