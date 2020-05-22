public static void findPatient() {
    System.out.print("Enter part of the patient name: ");
    String name = sc.nextLine();

    System.out.print(myPatientList.showPatients(name));
}

//the other class
ArrayList<String> patientList;

public void showPatients(String name) {
    boolean match = false;

    for(matchingname : patientList) {
        if (matchingname.toLowerCase.contains(name.toLowerCase())) {
            match = true;
        }
    }
}