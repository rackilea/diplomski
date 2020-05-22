return (List<Report>) sessionFactory.getCurrentSession()
.createCriteria(Report.class, "AllReport")
.createAlias("AllReport.acceptedReports", "AcceptedReport",
    //This is waht you were probably missing
    JoinType.LEFT_OUTER_JOIN,
    Restrictions.eq("AcceptedReport.idmoderator", idModerator) 
)
.add(Restrictions.isNull("AcceptedReport.idModerator"))
.list();