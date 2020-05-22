public void addPhoneNumber(Phone phone) {
    phone.setStudent(this);
    getStudentPhoneNumbers().add(phone);
}
public void addPhoneNumber(String type, String number) {
    addPhoneNumber(new Phone(type, number));
}