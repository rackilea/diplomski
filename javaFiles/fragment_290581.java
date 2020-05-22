StoredProcedureQuery q = em.createStoredProcedureQuery(Globals.SPROC_PROBLEM_COMMENT2, ProblemCommentVO.class);
q.registerStoredProcedureParameter("Patient_ID", Long.class, ParameterMode.IN);
q.registerStoredProcedureParameter("Param2", Long.class, ParameterMode.IN);
q.registerStoredProcedureParameter("Param3", Long.class, ParameterMode.IN);
q.registerStoredProcedureParameter("Param4", Integer.class, ParameterMode.OUT);
q.setParameter("Patient_ID", patientId);
q.setParameter("Param2", null);//passing null value to Param2
q.setParameter("Param3", null);

List<ProblemCommentVO> pComments = q.getResultList();
Integer a = (Integer) q.getOutputParameterValue("Param4");