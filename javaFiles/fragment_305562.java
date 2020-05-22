int batchSize = 1000;
try (SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH)) {
  YourMapper mapper = sqlSession.getMapper(YourMapper.class);
  int size = serviceCodeList.size();
  for (int i = 0; i < size;) {
    mapper.insertServiceCode(serviceCodeList.get(i));
    i++;
    if (i % batchSize == 0 || i == size) {
      sqlSession.flushStatements();
      sqlSession.clearCache();
    }
  }
  sqlSession.commit();
}