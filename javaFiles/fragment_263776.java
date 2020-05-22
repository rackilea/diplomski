boolean pin = false;
int newRowId = 0;
newRowId = (int) patientDao.addNewPatient(newPatient);
newPatient.setPid(newRowId);
if(0 != newRowId){
pin= true;}
assertTrue("addNewPatient is not true",pin);