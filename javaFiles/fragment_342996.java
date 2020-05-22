@Bean
public StandardFileSystemManager manager() {
    StandardFileSystemManager manager = new StandardFileSystemManager();
    manager.init(); 
    return manager;
}