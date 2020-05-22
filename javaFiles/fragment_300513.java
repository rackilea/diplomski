.... myMethod() {

String endpointURI ="http://127.0.0.1:8080/Foo-Services/FooQuartzManagerBean/FooQuartzManagerBean?WSDL";

//call webmethod instatianteJob
getPort(endpointURI).instantiateJob( ....

}