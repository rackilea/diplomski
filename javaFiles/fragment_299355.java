for (int i = 0; i < thestudents.size(); i++) 
{
    Student temp = thestudents.get(i);
    if (temp.getStudentID()==(Integer.parseInt(studentID))) 
    {
        thestudents.remove(i);
        System.out.println("Student " + temp.getFirstName() + " was removed");
        return; // leaving the method whe ID found
    }
}
// is only executed when ID not found
System.out.println("Student with ID " + studentID + " Was not found!)";