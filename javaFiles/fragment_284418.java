Service service = new Service();
Call  call    = (Call) service.createCall();


QName q = new QName("http://rpc.xml.coldfusion", "QueryBean");
BeanSerializerFactory bsf =   new BeanSerializerFactory(QueryBean.class, q);   // step 2
BeanDeserializerFactory bdf = new BeanDeserializerFactory(QueryBean.class, q);  // step 3
call.registerTypeMapping(QueryBean.class, q, bsf, bdf); //step 4

call.setTargetEndpointAddress(new java.net.URL(endpoint));
call.setOperationName(new QName(endpoint, "getReportContent"));
QueryBean bean = (QueryBean) call.invoke( new Object[] { "142", "5088721" });