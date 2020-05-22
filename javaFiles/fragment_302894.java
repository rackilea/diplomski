//          File base = new File("src/main/webapp");
//          context = tomcat.addContext("", base.getAbsolutePath());
//          tomcat.addWebapp(null, "/", base.getAbsolutePath());

        context = tomcat.addWebapp("/", new File("src/main/webapp").getAbsolutePath());
        context.setSessionTimeout(10080);