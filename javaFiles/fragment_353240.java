ServiceLoader<FrameworkFactory> ffs = ServiceLoader.load(FrameworkFactory.class);
FrameworkFactory ff = ffs.iterator().next();
Map<String,Object> config = new HashMap<String,Object>();
// add some params to config ...
Framework fwk = ff.newFramework(config);
fwk.start();