EntityMangerFactory oracleEmf = getOracleEntityMangerFactory();
EntityMangerFactory db2Emf = getdb2EntityMangerFactory();
EntityMangerFactory sqlEmf = getSqlServerEntityMangerFactory();

EntityManager oracleEm = oracleEmf.createEntityManager();
EntityManager db2Em = db2Emf.createEntityManager();
EntityManager sqlEm = sqlEmf.createEntityManager();

OracleEntity oe = oracleEm.find(OracleEntity.class, oracleEntityPrimaryKey);
DB2Entity db2e = db2Em.find(DB2Entity.class, db2EntityPrimaryKey);
SQLServerEntity soe = new SQLServerEntity(oe);
SQLServerEntity sdb2e = new SQLServerEntity(db2e);
sqlEm.persist(soe);
sqlEm.persist(sdb2e);