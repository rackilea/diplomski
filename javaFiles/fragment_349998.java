ResourceConfig config = new ResourceConfig();
config.packages("com.example.foo");

JacksonJsonProvider jjp = new JacksonJsonProvider();
jjp.setDefaultWriteView(ResourceView.PublicView.class);
config.register(jjp);