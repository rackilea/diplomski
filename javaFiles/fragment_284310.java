@Override
@Transactional
@SuppressWarnings("unchecked")
public List<AttendanceEntry> getAttendanceByDateSearch(String classId,  String sectionId, Date date) {
    Criteria cr = getSession().createCriteria(AttendanceEntry.class,"attendanceEntry")
        .createAlias("attendanceEntry.attendance","attendance")
        .setProjection(Projections.projectionList()
        .add(Projections.property("rollno"),"rollno")
        .add(Projections.property("absent"),"absent")
        .add(Projections.property("leave"),"leave")
        .add(Projections.property("od"),"od")
        .add(Projections.property("absentDate"),"absentDate")
        .add(Projections.groupProperty("rollno"),"rollno"))
        .add(Restrictions.eq("attendance.classYear.id", classId))
        .add(Restrictions.eq("attendance.section.id", sectionId))
        .add(Restrictions.eq("absentDate", date))
        .setResultTransformer(Transformers.aliasToBean(AttendanceEntry.class));
        return  cr.list(); 
}