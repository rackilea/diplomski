public List<CivilRecord> dashboardSearch(CivilRecordSearch civilRecordSearch)
      throws MessageException {
    SearchValidation.validateDashboardSearch(civilRecordSearch);
    List<CivilRecord> l = new ArrayList<>();
    try {
      StringBuilder query = new StringBuilder();
      //query.append("select c.id_civil_record\\:\\:text,c.nm_request,c.nm_rg,c.tx_name,c.dt_register,c.bl_priority ");
      query.append("select CAST(c.id_civil_record as text),c.nm_request,c.nm_rg,c.tx_name,c.dt_register,c.bl_priority ");
      query.append("from sc_civil.tb_civil_record c ");
      query.append("inner join sc_civil.tb_workflow_record w ");
      query.append("on w.id_civil_record = c.id_civil_record ");
      query.append("left join sc_civil.tb_lock l ");
      query.append("on l.id_record = c.id_civil_record ");
      query.append("where c.id_site = :idSite ");

      if (civilRecordSearch.getPriority() == null || civilRecordSearch.getPriority().equals(false))
        query.append("and c.bl_priority = :priority ");
      query.append("and c.bl_canceled = :canceled ");
      query.append("and w.id_type_workflow = :idTypeWorkflow ");
      query.append("and w.id_type_status_workflow = :idTypeStatusWorkflow ");

      query.append("and (l is null or l.id_user = CAST(:idUser AS uuid)) ");

      if (!StringUtils.isEmpty(civilRecordSearch.getName()))
        query.append("and c.tx_name ilike :name ");
      if (!StringUtils.isEmpty(civilRecordSearch.getRg()))
        query.append("and c.nm_rg like :rg ");

      if (civilRecordSearch.getRequestNumber() != null)
        query.append("and c.nm_request = :request ");

      query.append("order by c.bl_priority desc, c.dt_register ");

      Query q = em.createNativeQuery(query.toString());
      q.setParameter("idSite", civilRecordSearch.getSite().getId());
      if (civilRecordSearch.getPriority() == null || civilRecordSearch.getPriority().equals(false))
        q.setParameter("priority", false);
      q.setParameter("idTypeWorkflow", civilRecordSearch.getTypeworkflow().getId());
      q.setParameter("idTypeStatusWorkflow", civilRecordSearch.getTypestatusworkflow().getId());
      q.setParameter("idUser", civilRecordSearch.getIdUser().toString());
      q.setParameter("canceled", false);
      if (!StringUtils.isEmpty(civilRecordSearch.getName()))
        q.setParameter("name","%" + civilRecordSearch.getName() + "%");
      if (civilRecordSearch.getRequestNumber() != null)
        q.setParameter("request", civilRecordSearch.getRequestNumber());
      if (!StringUtils.isEmpty(civilRecordSearch.getRg()))
        q.setParameter("rg", civilRecordSearch.getRg());

      q.setMaxResults(maxResult);
      List<Object[]> lo = q.getResultList();
      em.clear();
      for(Object[] o : lo){
          CivilRecord c = new CivilRecord();
          c.setIdCivilRecord(UUID.fromString((String)o[0]));
          c.setRequest(((BigInteger)o[1]).longValue());
          c.setRg((String)o[2]);
          c.setName((String)o[3]);
          c.setRegister((Date)o[4]);
          c.setPriority(TypeYesNo.getByKey(((Boolean)o[5]).booleanValue()));
          c.setWorkflowRecords(findStatus(c.getIdCivilRecord()));
          l.add(c);
      }
      return l;
    } catch (Exception e) {
      log.severe(e.getMessage());
      throw e;
    }
  }