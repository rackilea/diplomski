Environment environment = new Environment("TEST", new JdbcTransactionFactory(), dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMappers("com.mdv.dao");

        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = ssf.openSession(ExecutorType.BATCH);
        try {

            StagingFileMapper sfm = sqlSession.getMapper(StagingFileMapper.class);
            for(Record r : staging){
                StagingFile sf = new StagingFile();
                //set your sf fields
                sfm.insert(sf);
            }
            sqlSession.commit();
        } catch (Exception e) {
            //manage exception
        }
        finally{
            sqlSession.close();
        }