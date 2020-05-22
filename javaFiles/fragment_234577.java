SecRule REQUEST_LINE "@contains myapp/access/PageServlet?url=/notices/dummyNotifPage.jsp" "chain,phase:2,t:none,status:403,msg:'Generic javascript Injection prevention',severity:2"
SecRule ARGS|QUERY_STRING "(<[^>]*>)" "status:403"
 
SecRule REQUEST_LINE "@contains myapp/access/PageServlet?url=/notices/dummyNotifPage.jsp" "chain,phase:2,t:none,status:403,msg:'Generic javascript Injection prevention',severity:2"
SecRule ARGS|QUERY_STRING "(?i)javascript:" "status:403"
 
SecRule REQUEST_LINE "@contains myapp/access/PageServlet?url=" "chain,phase:2,t:none,status:403,msg:'Check for double slashes in url parameter',severity:2"
SecRule ARGS|QUERY_STRING "/{2}" "status:403"