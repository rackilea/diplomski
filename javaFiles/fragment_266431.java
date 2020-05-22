public static void main(String[] args) {
    ClassSet<Object> instances = new ClassSet<Object>();

    instances.add("hello");
    instances.add(1234);
    instances.add("will not be added");

    System.out.println(instances.map);
}