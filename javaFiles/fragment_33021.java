public interface FileDefinition<K, V extends FileEntry, T extends ParsedFile<K, V>>{...


public void myMethod(){
     for (FileDefinition<?, ?, ?> def : defs){
         process(def);
     }
}

private <K, V extends FileEntry, T extends ParsedFile<K, V>> process(FileDefinition<K, V, T> def){
     Factory<T> factory = def.getFactory();
     MetricsProducer<K, V> producer = def.getMetricsProducer();
     ParsedFile<K, V> parsedFile = factory.parseFile();
     Metrics metrics = producer.generateMetrics(parsedFile);
}