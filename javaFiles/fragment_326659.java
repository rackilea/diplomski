import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.base64.Base64;
import org.jboss.netty.handler.codec.http.DefaultHttpRequest;
import org.jboss.netty.handler.codec.http.HttpChunkAggregator;
import org.jboss.netty.handler.codec.http.HttpClientCodec;
import org.jboss.netty.handler.codec.http.HttpHeaders;
import org.jboss.netty.handler.codec.http.HttpMethod;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.jboss.netty.handler.codec.http.HttpVersion;
import org.jboss.netty.util.CharsetUtil;

public class BasicAuthTest {
private static final int PORT = 80;
private static final String USERNAME = "";
private static final String PASSWORD = "";
private static final String URI = "";
private static final String HOST = "";

public static void main(String[] args) {

    ClientBootstrap client = new ClientBootstrap(
            new NioClientSocketChannelFactory(
                    Executors.newCachedThreadPool(),
                    Executors.newCachedThreadPool()));

    client.setPipelineFactory(new ChannelPipelineFactory() {

        @Override
        public ChannelPipeline getPipeline() throws Exception {
            ChannelPipeline pipeline = Channels.pipeline();
            pipeline.addLast("codec", new HttpClientCodec());
            pipeline.addLast("aggregator", new HttpChunkAggregator(5242880));
            pipeline.addLast("authHandler", new ClientMessageHandler());
            return pipeline;
        }
    });

    DefaultHttpRequest request = new DefaultHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, URI);

    request.addHeader(HttpHeaders.Names.HOST, HOST);

    String authString = USERNAME + ":" + PASSWORD;
    ChannelBuffer authChannelBuffer = ChannelBuffers.copiedBuffer(authString, CharsetUtil.UTF_8);
    ChannelBuffer encodedAuthChannelBuffer = Base64.encode(authChannelBuffer);
    request.addHeader(HttpHeaders.Names.AUTHORIZATION, encodedAuthChannelBuffer.toString(CharsetUtil.UTF_8));

    client.connect(new InetSocketAddress(HOST, PORT)).awaitUninterruptibly().getChannel()
            .write(request).awaitUninterruptibly();

}

public static class ClientMessageHandler extends SimpleChannelHandler {
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        e.getCause().printStackTrace();
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        HttpResponse httpResponse = (HttpResponse) e.getMessage();
        String json = httpResponse.getContent().toString(CharsetUtil.UTF_8);
        System.out.println(json);
    }
}

}