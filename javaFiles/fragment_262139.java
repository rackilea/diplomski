public Processor[] createProcessors() {
    Processor[] processors = new Processor[objectList.size()];
    for (int i = 0; i < objectList.size(); i++) {
        processors[i] = objectList.get(i).createProcessor();
    }
}