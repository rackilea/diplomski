public void removeTutee(Student x) {
    for(Tutor t: tutorList){
        if(t.getStudent().getId() == x.getId()){
            t.setTutee(null);
            break;
        }
    } 
}