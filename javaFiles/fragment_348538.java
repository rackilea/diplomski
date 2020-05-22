public void update(Student student1)
{
    //student1 is in detached status, you may modify it if not yet done
    student1.setName("ABC");

    //now load a student2 from db with the same id, note student2 is in persistent status
    Student student2 = currentSession().load(Student.class, student1.getId());

    //merge student1 to student2 and return a new student3
    Student student3 = currentSession().merge(student1);
    //--done, checkout student3, you will see "ABC" is merged. You can't call update() in this case. 
    return;
}