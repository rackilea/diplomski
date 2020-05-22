List<Doctor> doctors = queryDoctor(results -> {
       Doctor doctor = new Doctor();
        doctor.setId(results.getInt(1));
        doctor.setUserName(results.getString(2));
        doctor.setPassword(results.getString(3));
        doctor.setPassword_salt(results.getString(4));
        doctor.setRole(results.getInt(5));
        return doctor;
});