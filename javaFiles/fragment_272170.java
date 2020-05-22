public enum Module {
  MODULE1(Context1.class), MODULE2(Context2.class), MODULE3(Context3.class);
  Module(Class contextClass) ...
}

SpringApplicationBuilder builder = new SpringApplicationBuilder()
    .sources(Parent.class)
    .bannerMode(Banner.Mode.OFF);
String[] modules = args[0].split(",");
for(int i = 0; i < modules.length; i++){
  builder.child(Module.valueOf(modules[i]).contextClass);
}
builder.run(args);