try{
    QueryRequest c = new QueryRequest("testcaseresult");
    c.setFetch(new Fetch("testcase"));
    c.setQueryFilter(new QueryFilter("testcase", "=", testCaseRef));
    QueryResponse cc = r.query(c);
    String testresultRef = cc.getResults().get(0).getAsJsonObject().get("_ref").toString();
} catch(IndexOutOfBoundsException e){
    //Create a testcaseresult here.
}