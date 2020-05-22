StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("mvm.CHECK_USER");


        storedProcedureQuery.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(3, Long.class, ParameterMode.INOUT);


        storedProcedureQuery.setParameter(1, user);
        storedProcedureQuery.setParameter(2, password);
        storedProcedureQuery.setParameter(3, new Long(3));

        Long outputValue2 = (Long) storedProcedureQuery.getOutputParameterValue(3);