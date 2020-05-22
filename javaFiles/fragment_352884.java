@Test
public void testSecondLevelCache() {
    long hitCount = m_cache.getStatistics().getCacheHits();       
    final String countryId = m_testProps.getProperty("test.country.id");

    transactionTemplate.execute((TransactionCallback<Void>) transactionStatus -> {            
        m_countryDao.findById(countryId);
        return null;
    });

    transactionTemplate.execute((TransactionCallback<Void>) transactionStatus -> {
        m_countryDao.findById(countryId);
        return null;
    });
}