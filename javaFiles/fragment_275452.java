// Doesn't handle collisions (you might want to use a multimap such as http://docs.guava-libraries.googlecode.com/git/javadoc/com/google/common/collect/Multimap.html instead)
Map<String, Class<?>> classBySimpleName = new HashMap<>();

for(Class<?> c : allClasses) {
    classBySimpleName.put(c.getSimpleName(), c);         
}