class LibraryPatron {
    class MakeClassB implements INeedAFactory.MyFactory {
        public ClassA makeClassAInstance() {
            return new ClassB();
        }
    }
    public LibraryPatron() {
        INeedAFactory libraryObject = new INeedAFactory();
        libraryObject.registerFactory(new MakeClassB());
        // ... etc...
    }
}