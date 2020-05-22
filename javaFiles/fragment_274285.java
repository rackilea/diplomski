public static void main(String[] args)
{
    //gives a name to the students
    Student stud1 = new Student("Samantha", "Jones");
    Student stud2 = new Student("Timo", "Hantee");    

    //each object calls the getName method
    System.out.println("The students first name is: " + stud1.getFirstName());
    System.out.println("The students last name is: " + stud2.getLastName());    
}