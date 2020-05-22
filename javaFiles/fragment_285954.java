public class MyInterceptor extends AbstractPhaseInterceptor<Message> {

    public MyInterceptor() {
        super(Phase.POST_STREAM);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        if (message != null) {
            //check the condition to raise the error 
            //build the custom Response replacing service call
            Response response = Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("custom error")
                    .build();
            message.getExchange().put(Response.class, response);

            //abort interceptor chain in you want to stop processing or throw a Fault (catched by handleFault)
            //message.getInterceptorChain().abort();
            //throw new Fault (new MyException());

        }

    public void handleFault(Message messageParam) {
    }
}