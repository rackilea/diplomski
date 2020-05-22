interface QueryService {
   public FutureTask<QueryResult> query(Query q);
}

FutureTask<QueryResult> res = query(..);
// do work
res.get(); // blocks until result is in