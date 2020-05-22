public static void main(String[] args){

   School school = new School();
   Teacher t1 = new Teacher();
   Student s1 = new Student();

   school.addPeople(t1);
   school.addPeople(s1);

   //Polymorphism
   for(Person p: school.getPeople()){
       p.getName(); /* Here the function will be
                       called depending if its a Teacher or Student at runtime */
    }


}