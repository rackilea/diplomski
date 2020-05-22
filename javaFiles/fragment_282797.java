package org.company.app;




import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class Application {
    public static void main(final String[] args) throws Exception {

        final String webappPath = new File("src/main/webapp").getAbsolutePath();
        final Tomcat tomcat = new Tomcat();

        final StandardContext ctx = (StandardContext) tomcat.addWebapp("/", webappPath);
        System.out.println(ctx
        );
        // Declare an alternative location for your "WEB-INF/classes" dir
        // Servlet 3.0 annotation will work
        final String targetClassesPath = new File("target/classes").getAbsolutePath();
        final WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(//
                resources, "/WEB-INF/classes", //
                targetClassesPath, "/"));
        ctx.setResources(resources);

        tomcat.start();
        tomcat.getServer().await();
    }
}