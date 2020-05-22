String webservice310 = "localhost:8080/api/importxml/version310";
String webservice200 = "localhost:8080/api/importxml/version200";
String dir = "c:/imports/";

from("file:" + dir + "?include=.*.xml&delay=1000&move=successImport&moveFailed=failImport")
.process(new ProcessadorNfe())
.onException(RestletOperationException.class)
    .handled(false)
    .maximumRedeliveries(-1).delay(60 * 1000)
    .end()
.choice()
    .when(header("version").isEqualTo("3.10"))
        .to("restlet:"+ webservice310 + "?restletMethod=post")
    .when(header("version").isEqualTo("2.00"))
        .to("restlet:"+ webservice200 + "?restletMethod=post")