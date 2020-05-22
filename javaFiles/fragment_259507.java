Patient removePatient = new Patient (deletelName.toLowerCase(),null,null,null,null);

while (!bst.contains(removePatient)) {
    System.out.println("Patient's last name does not exist. Type another last name : ");
    deletelName = cin.next();
    removePatient = new Patient (deletelName.toLowerCase(),null,null,null,null);

}