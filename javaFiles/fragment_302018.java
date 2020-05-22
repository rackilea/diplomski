try {
  Session session = NotesFactory.createSession((String) null, (String) null, "defaultPassword");
  if(session != null) {
    //do sth.
  }
}
catch (NotesException e) {

}