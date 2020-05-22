public Assessment getAssessmentById(Long assessmentId, Object tenantId) throws HibernateException {
        Session session = getSession(tenantId);
        Assessment result;
        result = (Assessment) session
            .createCriteria(Assessment.class)
            .setFetchMode("propertyAssessment", FetchMode.JOIN)
            .createAlias("propertyAssessment.propertyOwners", "propertyOwners", JoinType.LEFT_OUTER_JOIN)
            .setFetchMode("propertyAssessment.subOffice", FetchMode.JOIN)
            .setFetchMode("propertyAssessment.ward", FetchMode.JOIN)
            .setFetchMode("propertyAssessment.gramaNiladhariDivision", FetchMode.JOIN)
            .setFetchMode("propertyAssessment.propertyDescription", FetchMode.JOIN)
            .setFetchMode("propertyAssessment.propertyType", FetchMode.JOIN)
            .setFetchMode("propertyAssessment.road", FetchMode.JOIN).setFetchMode("registerNumber", FetchMode.JOIN)
            .setFetchMode("registerPageNumbers", FetchMode.JOIN).setFetchMode("elgActivity", FetchMode.JOIN)
            .add(Restrictions.eq("id", assessmentId))
            .add(Restrictions.ne("propertyOwners.status", ScandiumKeyBox.INACTIVE))
            .uniqueResult();
        return result;
    }