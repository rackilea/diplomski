Student s = findStudentWithName(fullList, this.name);
if (s == null) {
    Student s = new Student(this.name); 
    s.setResult(this);
    fullList.add(s);
}
else {
    s.setResult(this);
}