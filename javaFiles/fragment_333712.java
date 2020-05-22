public synchronized Restlet createInboundRoot()
{
 Router router = new Router();
 router.attach("/helloworld",HelloWorldResource.class);
 router.attach("/hello",HelloWorldResource1.class);
 Filter fil1 = filterObj();
 fil1.setNext(router);
 return fil1;
}