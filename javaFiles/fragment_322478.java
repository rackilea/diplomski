private Future<StatelessSession> getStatelessSession(SessionFactory sessionFactory)
{
    return asyncTaskExecutor.submit(new Callable<StatelessSession>()
    {

        @Override
        public StatelessSession call() throws Exception
        {
            return sessionFactory.openStatelessSession();
        }
    });
}

try {
    StatelessSession session = getStatelessSession(sessionFactory).get(3000,TimeUnit.MILLISECONDS);
} catch (TimeoutException e) {
    // go to step 2
}