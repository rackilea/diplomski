Query query = sf.getCurrentSession()
                .createSQLQuery(
                "CALL Procedure_Name(:movimentoId)")
                .addEntity(ClassName.class)
                .setParameter("movimentoId", "ur_Id");

            List result = query.list();