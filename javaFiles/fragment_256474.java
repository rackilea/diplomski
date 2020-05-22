public static void main(String[] args)
{
    String host = "localhost";
    int port = 8090;
    ChannelFactory factory = new NioClientSocketChannelFactory(Executors
            .newCachedThreadPool(), Executors.newCachedThreadPool());
    MyHandler handler1 = new MyHandler();
    PipelineFactory factory1 = new PipelineFactory(handler1);
    AnotherHandler handler2 = new AnotherHandler();
    PipelineFactory factory2 = new PipelineFactory(handler2);
    ClientBootstrap bootstrap = new ClientBootstrap(factory);
    // At client side option is tcpNoDelay and at server child.tcpNoDelay
    bootstrap.setOption("tcpNoDelay", true);
    bootstrap.setOption("keepAlive", true);
    for (int i = 1; i<=50;i++){
        if(i%2==0){
            bootstrap.setPipelineFactory(factory1);
        }else{
            bootstrap.setPipelineFactory(factory2);
        }

        ChannelFuture future = bootstrap.connect(new InetSocketAddress(host,
                port));

        future.addListener(new ChannelFutureListener()
        {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception
            {
                future.getChannel().write("SUCCESS");
            }
        });
    }
}