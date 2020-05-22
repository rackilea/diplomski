public class Example {

    public static void main(String[] args) {
        final ChannelPipelineHandlerImpl perDatagramFactory = new ChannelPipelineHandlerImpl();

        DatagramChannelFactory udpFactory = new NioDatagramChannelFactory(Executors.newCachedThreadPool());

        ConnectionlessBootstrap udpBootstrap = new ConnectionlessBootstrap(udpFactory);

        udpBootstrap.setPipelineFactory(new ChannelPipelineFactory() {

            public ChannelPipeline getPipeline() throws Exception {
                return Channels.pipeline(new DistinctChannelPipelineHandler(perDatagramFactory));
            }
        });

    }

    private static final class DistinctChannelPipelineHandler implements ChannelDownstreamHandler, ChannelUpstreamHandler {
        private ChannelPipelineFactory factory;

        public DistinctChannelPipelineHandler(ChannelPipelineFactory factory) {
            this.factory = factory;
        }

        public void handleUpstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
            ChannelPipeline pipeline = factory.getPipeline();
            pipeline.attach(ctx.getChannel(), ctx.getPipeline().getSink());
            pipeline.sendUpstream(e);

            ctx.sendUpstream(e);

        }

        public void handleDownstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
            ChannelPipeline pipeline = factory.getPipeline();
            pipeline.attach(ctx.getChannel(), ctx.getPipeline().getSink());
            pipeline.sendDownstream(e);

            ctx.sendDownstream(e);
        }

    }

    private static final class ChannelPipelineHandlerImpl implements ChannelPipelineFactory {

        public ChannelPipeline getPipeline() throws Exception {
            // Add your handlers here
            return Channels.pipeline();
        }

    }
}