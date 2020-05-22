StringBuffer sql = new StringBuffer();

sql.append( " SELECT CR " );
sql.append( " FROM CommitmentRegisterDetail CRD " );
sql.append( " LEFT JOIN CRD.commitmentRegister CR ");
sql.append( " WHERE CR.id >= 91000 " );
sql.append( " GROUP BY CRD.commitmentRegister " );
sql.append( " HAVING SUM( CRD.amount ) > 100 " );

Query q = em.createQuery( sql.toString() );

return q.getResultList();