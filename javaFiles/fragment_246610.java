public Assessment(int id, String date, int doctorID, int childID,
        ArrayList<Question> questions) {
    questions = new ArrayList<Question>(); //<-- here you make a NEW empty ArrayList
    this.id = id;
    this.setDate(date);
    this.setDoctorID(doctorID);
    this.setChildID(childID);
    this.setQuestions(questions); //<-- here you setQuestions as the empty arraylist

}