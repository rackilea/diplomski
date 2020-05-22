public Class Course{
   List<Lecturer> lecturerCollection= new ArrayList<Lecturer>();

//this method will be called with a lecturer object
public void       addCordinator(Lecturer newLecturer){
   lecturerCollection.add(newLecturer);
}