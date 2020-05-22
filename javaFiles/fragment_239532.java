public Collection<Doctor> getDoctors() {
    Collection<Doctor> result = new ArrayList<>(doctors.size());
    for (HospitalToDoctor hospitalToDoctor : doctors) {
        result.add(hospitalToDoctor.getDoctor());
    }
    return result;
}