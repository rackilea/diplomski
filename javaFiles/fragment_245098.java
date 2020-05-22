[base-command-line]$ java -Dfoo=bar -jar /path/to/jetty-distribution-9.2.7.v20150116/start.jar
2015-02-23 09:15:46.088:INFO::main: Logging initialized @290ms
2015-02-23 09:15:46.222:INFO:oejs.Server:main: jetty-9.2.7.v20150116
2015-02-23 09:15:46.235:INFO:oejdp.ScanningAppProvider:main: Deployment monitor [file:/home/joakim/code/stackoverflow/jetty-external-config/base-command-line/webapps/] at interval 1
2015-02-23 09:15:46.325:INFO:oejw.StandardDescriptorProcessor:main: NO JSP Support for /props, did not find org.eclipse.jetty.jsp.JettyJspServlet
2015-02-23 09:15:46.343:INFO:oejsh.ContextHandler:main: Started o.e.j.w.WebAppContext@6e7f61a3{/props,file:/tmp/jetty-0.0.0.0-9090-props.war-_props-any-27537844855769703.dir/webapp/,AVAILABLE}{/props.war}
2015-02-23 09:15:46.353:INFO:oejs.ServerConnector:main: Started ServerConnector@67cd35c5{HTTP/1.1}{0.0.0.0:9090}
2015-02-23 09:15:46.353:INFO:oejs.Server:main: Started @555ms