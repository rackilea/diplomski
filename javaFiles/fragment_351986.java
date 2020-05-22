List<Interface> list = new ArrayList<>();
list.add(new ClassOne());
list.add(new ClassTwo());
list.add(new ClassThree());
for(Interface instance : list) {
    instance.action();
}