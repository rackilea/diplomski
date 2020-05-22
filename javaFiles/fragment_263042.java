File baseDir = new File("dist/target/dist-1.0-SNAPSHOT-bin/plugins/");
String baseDirPath = baseDir.getAbsolutePath();

loadScrBundle(framework);

File provider = new File(baseDirPath, "OSGiDmHelloWorldProvider-1.0-SNAPSHOT.jar");
File consumer = new File(baseDirPath, "OSGiDmHelloWorldConsumer-1.0-SNAPSHOT.jar");

framework.getBundleContext().installBundle(provider.toURI().toString());
framework.getBundleContext().installBundle(consumer.toURI().toString());