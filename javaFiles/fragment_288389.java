from("direct:start")
.doTry()
    .to("smtp://matt@stackoverflow.com")
.doCatch(Exception.class)
    .to("log:somethings wrong")
.doFinally()
    .to("mock:finally")
.end();