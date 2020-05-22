public int getPhoneNumber(int stuID){
    for (Student s: studList) {
        if(s.id == stuID){
            return s.phoneNumber;
        }
    }
    return 0;
}