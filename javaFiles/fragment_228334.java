public static void admitPatient(Patient patient) {
    if(numofPatients < maxPatients){
        patients.put(patient.getID(), patient);
    }
}

public static void dischargePatient(String id) {
    patients.remove(id);
}