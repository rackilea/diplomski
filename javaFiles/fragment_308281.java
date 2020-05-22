from("timer:invoke?repeatCount=1")
        .log("Processing ${id}")
        .toD("https4://URL")
        .inheritErrorHandler(true)
        .unmarshal()
        .json(JsonLibrary.Jackson)
        .split(body())
        .parallelProcessing()
        .process(new MyProcessor())
        .to("jpa:ExampleTable")
        .process(new Processor() {
                public void process(Exchange arg0) throws Exception {
                    List<Table2> info= ((ExampleTable) arg0.getIn().getBody()).getAuditInfo();
                    if (null != info&& info.size() > 0) {
                        arg0.getIn().setBody(info);
                    }else{
                        arg0.getIn().setBody(new ArrayList<Table2>());
                    }

                }
            })
            .to("jpa:Table2?entityType=java.util.ArrayList");