List<Object[]> attendanceTempList = ds.doQuery("SELECT distinct a.staf.stafPK.kod, a.attendancedate FROM StaffAttendanceTemp a"
    + " WHERE a.staf.stafPK.companyid = :companyid")
        .setParameter("companyid", this.getSession().getCompanyid()).getResultList();

for (Object[] listContent : attendanceTempList) {
//deal with Object[] here
}