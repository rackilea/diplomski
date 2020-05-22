static void SortPatient(ListInterface<Patient> patientList) {
    if (patientList == NULL)
    return;

   boolean swapped;
   Patient patent;

    do
    {
      swapped = false;
      patient = head;
      while (patientList.next != null)
      {
          if (patient.compareTo(patientList.next) < 1)
          {
              swap(patientList.current, patientList.next);
              swapped = true;
          }
          patient = patientList.next;
      }
    } while (swapped);
}