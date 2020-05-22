NamedList<Object> solrResponse = server.request(new QueryRequest(queryString));
NamedList<Object> namedList = (NamedList<Object>) solrResponse.get("termVectors");
for (int i = 0; i < namedList.size(); i +=2) {
                    Object val = namedList.getVal(i);
                    System.out.println(val.toString());//I chose to print them.
}