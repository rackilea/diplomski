public List<Category> getCategories(List<Integer> testRunIDs, String category, String testCaseName)
    {
        Session session = getSession();


        if (testRunIDs != null && testRunIDs.size() != 0)
        {
            session.enableFilter("TEST_RUN_ID_FILTER").setParameterList("IDS", testRunIDs);
        }

        if (testCaseName != null)
        {
            session.enableFilter("TESTCASE_NAME_FILTER").setParameter("TESTCASENAME", testCaseName);
        }

        /*
         * Hibernate wants to do an (left) outer join be default.
         * This bit of HQL is required to get it to do an inner join.
         * The query tells Hibernate to do an inner join on the testCases property inside the Category object
         */

        Query query = session.createQuery("select distinct c from Category c inner join c.testCases tc");
        List<Category> result = query.list();
        return result;
    }