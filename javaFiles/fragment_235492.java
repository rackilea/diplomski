Class a = new GroovyClassLoader().parseClass(aSourceString);//your A class; 
Class b = new GroovyClassLoader().parseClass(bSourceString);//your B class

ExpandoMetaClass emc = new ExpandoMetaClass(a, false, true);

List<Class> classes = new ArrayList<Class>();
classes.add(b);
MixinInMetaClass.mixinClassesToMetaClass(emc, classes);

MetaClassRegistry mcreg = MetaClassRegistryImpl.getInstance(MetaClassRegistryImpl.LOAD_DEFAULT);
mcreg.setMetaClass(a, emc);
emc.initialize();

System.out.println(((GroovyObject)j.newInstance()).invokeMethod("setContext", new Context()));//or however you get a Context obj