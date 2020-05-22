package com.scotth.jettypublish;

import javax.xml.ws.Endpoint;

import org.eclipse.jetty.http.spi.DelegatingThreadPool;
import org.eclipse.jetty.http.spi.JettyHttpServerProvider;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

import com.scotth.jettypublish.ws.HelloWorld;
import com.scotth.jettypublish.ws.impl.HelloWorldImplOne;
import com.scotth.jettypublish.ws.impl.HelloWorldImplThree;
import com.scotth.jettypublish.ws.impl.HelloWorldImplTwo;

public class PublishTesterMain {

    public static void main(String[] args) throws Exception {

        Server ws1 = new Server(new DelegatingThreadPool(new QueuedThreadPool()));
        ServerConnector connector = new ServerConnector(ws1);
        connector.setPort(8081);
        ws1.addConnector(connector);
        ContextHandlerCollection contexts = new ContextHandlerCollection();
        ws1.setHandler(contexts);

        Server ws2 = new Server(new DelegatingThreadPool(new QueuedThreadPool()));
        ServerConnector connector2 = new ServerConnector(ws2);
        connector2.setPort(8082);
        ws2.addConnector(connector2);
        ContextHandlerCollection contexts2 = new ContextHandlerCollection();
        ws2.setHandler(contexts2);

        System.setProperty("com.sun.net.httpserver.HttpServerProvider", JettyHttpServerProvider.class.getName());

        HelloWorld service1 = new HelloWorldImplOne();
        HelloWorld service2 = new HelloWorldImplTwo();

        JettyHttpServerProvider.setServer(ws1);
        Endpoint.publish("http://0.0.0.0:8081/services/Service1", service1);
        Endpoint.publish("http://0.0.0.0:8081/services/Service2", service2);
        ws1.start();

        HelloWorld service3 = new HelloWorldImplThree();

        JettyHttpServerProvider.setServer(ws2);
        Endpoint.publish("http://0.0.0.0:8082/services/Service3", service3);
        ws2.start();
        Thread.sleep(Long.MAX_VALUE);
    }

}