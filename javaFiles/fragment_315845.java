Map<String, ClassroomSession> classroomSessions = new TreeMap<String, ClassroomSession>();
int count = 0;
for (Classroom classTmp: classrooms) {
    count++;
    String name = "sessionClassroom" + count;
    SessionClassroom s  = new SessionClassroom(classTmp);
    classroomSessions.put(name, s);
}