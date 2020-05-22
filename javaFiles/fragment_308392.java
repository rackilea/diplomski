ThreadContext.put("traceId", yourTraceIdentifier); 

// invoke whatever
// which will, in turn, invoke Hibernate
// which will do some logging

ThreadContext.clear();