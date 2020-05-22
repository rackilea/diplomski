int j = 0;
while (studentList.size() > j) {
    if(studentList.get(j).getSchool().equals(school)){
        System.out.println(studentList.get(j));
        break;
    }
    j++;
}