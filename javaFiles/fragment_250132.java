public static void main(String[] args) {
    List<Students> students = new ArrayList<Students>();
    students.add("Jhon", 10);
    students.add("Mary", 5.5);
    students.add("Ana", 3);

    Iterator i = students.iterator();

    //iterate through your students list like tihs;
    while(i.hasNext()) {
        System.out.println("Student = "+ i.next());
    }
   // do what ever you want with the list 
   // make your calculations and stuff, what your problem required
}