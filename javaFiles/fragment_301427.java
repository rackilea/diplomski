public class Foo {
        private Map<Class<? extends MyClass1>, List<? extends MyClass2<? extends MyClass3, ? extends MyClass1>>> bar;

        public <T extends MyClass1> void add(Class<T> myClass, List<? extends MyClass2<? extends MyClass3, T>>> myList) {
            bar.put(myClass, myList);
        }

        ...
    }