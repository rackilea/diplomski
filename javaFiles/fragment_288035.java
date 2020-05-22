class INeedAFactory {
    public Interface MyFactory {
        public ClassA makeClassAInstance();
    }

    private MyFactory m_factory;
    public registerFactory(MyFactory factory) {
        m_factory = factory;
    }

    private ClassA makeClassAInstance() {
        // m_factory had better not be null!
        return m_factory.makeClassAInstance();
    }

    private void ClassAConsumer() {
        ClassA classA = makeClassAInstance();
        // ... etc. ...
    }
}