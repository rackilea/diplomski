for (Student s : fullList) {
     if (s.getName().equalsIgnoreCase(this.name)) { // current student has same name as result
         s.setResult(this);
     }
     else { // current student doesn't have the same name as result
        Student s = new Student(this.name); 
        s.setResult(this);
        fullList.add(s);
     }
}