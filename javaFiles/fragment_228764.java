ListIterator<Student> listIterator = studentList.listIterator(); //use list Iterator

while(listIterator.hasNext()) {
    if(iterator.next().getSchool().equals(school)) {
        System.out.println(listIterator.next());
        break;
    }
}