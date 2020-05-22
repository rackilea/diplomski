public String outputStudents(List<STUDENT> studentsList) {
       StringBuilder sb = new StringBuilder();
       foreach (STUDENT student: studentLIst) {
               sb.append(student.names);
               sb.append(",");
               sb.append(student.age);
               sb.append(";");
       }
       return sb;
    }