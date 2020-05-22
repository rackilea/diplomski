public class Patient {

private static Patient patientInstance;

private String patient_name;

//private contrunctor to prevent from creating patient instance directly through constructor.
private Patient() {
}

public static Patient getInstance() {
  if (patientInstance == null) {
    patientInstance = new Patient();
  }
  return patientInstance;
}

public void setPatientName( String patientName ){
  this.patient_name = patientName;
}

public String getPatientName( ){
  return this.patient_name;
}
}