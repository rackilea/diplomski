AtmosphereServlet s = new AtmosphereServlet();
AtmosphereFramework f = s.framework();

ReflectorServletProcessor r = new ReflectorServletProcessor();
r.setServletClassName("com.sun.jersey.spi.spring.container.servlet.SpringServlet");

f.addAtmosphereHandler("/api/*", r);

ServletRegistration atmosphereServletRegistration = ctx.addServlet("AtmosphereServlet", s);