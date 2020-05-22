public class GarbageCollectionReferenceShareDemo {

        private Object objectReference;

        public void runDemo() {
            final Object methodReference = new Object();
            objectReference = methodReference;
        }
    }