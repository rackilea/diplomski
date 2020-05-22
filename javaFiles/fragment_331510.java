Patient foundPatient = searchPatientById(idToFind);
if (foundPatient != null) {
    foundPatient.setBoolAllergy(patientsAllergyState);
} else {
    // whatever you need to do if the patient cannot be found
}