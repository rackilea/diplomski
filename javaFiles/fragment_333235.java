public Map<String, Integer> studentsByTeacherCount(ObservableList<Student> data) {

    Map<String, Integer> teacherMap = new HashMap<String, Integer>();

    for (int i = 0; i < data.size(); i++) {
        Student student = data.get(i);
        List<Subject> subjectList = student.getCollectionz();
        for(Subject subject: subjectList) {
            Integer entry = teacherMap.get(subject.getTeacher());
            if(entry == null) {
                teacherMap.put(subject.getTeacher(), Integer.valueOf(1));
            } else {
                teacherMap.put(subject.getTeacher(), entry + 1);
            }
        }

    }

    return teacherMap;
}