Criteria query = session.createCriteria(Patient.class)
                    .add(Restrictions.eq("phone", phone));

List<Patient> patList = (ArrayList<Patient>) query.list();

String result="";
if(!patList.isEmpty()) {
    Patient patient=patList.get(0);
    result="Doc Phone : " + patient.getDoctor().getPhone();
}
return result;