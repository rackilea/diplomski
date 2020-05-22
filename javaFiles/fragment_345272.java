private PropertyInfo parse(...) { // take some parameters
    // Find your getter and setter through reflection
    final Method getter = ...
    final Method setter = ...
    return new PropertyInfo() {
        public Object get() {
            // Use the getter
        }
        public void set(Object value) {
            // Use the setter
        }
    };
}