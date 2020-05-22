public void addAttendee(String id, String email){
       LinkedList<String> myList = new LinkedList<>();
       myList.add(id);
       myList.add(email);
       this.student.add(myList);
}