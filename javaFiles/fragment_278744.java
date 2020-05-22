String hql = "SELECT avg(stock.price) from Stock stock where (stock.name = :stockName and stock.date in (select stock.date from stock where stock.name = :stockName))";
Query query = session.createQuery(hql);
query.setParameter("stockName", "stockName");
List results = query.list();

// If you want to fetch only 10 rows then
query.setMaxResults(10); //it takes only an integer parameter