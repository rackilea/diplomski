long[] accountIds= {327913,327652,327910,330511,330643};
   List<Account> afterHql = getHibernateTemplate().find(query, accountIds);
   List<Account> sortedList = new ArrayList<Acount>();
   for (long id : accountIds)
   {
       for (Account account : afterHql)
       {
           if (account.getId() == id)
           {
               sortedList.add(account);
           }
       }
   }