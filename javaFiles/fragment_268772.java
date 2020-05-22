public String format() 
{
ListIterator<Student> iterator 
        = studentList.listIterator();

for (Student student: studentList)
{
    System.out.println("For Loop");       

        return String.format("%s%s%s", 
        student.getSurName(), student.getForeName(),
        student.getStudentId());     

}   
 return null;   
}