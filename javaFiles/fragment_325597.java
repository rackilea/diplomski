void removePatient(String patientName) {
    Person deleteThat;
    for (Patient p : ts){
       if(p.getName().equals(patientName){
           deleteThat = p;
       }
    }
    if(deleteThat != null){
        ts.remove(deleteThat);
    }
}