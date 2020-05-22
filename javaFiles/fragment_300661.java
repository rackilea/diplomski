List<Class> interfaces = new LinkedList<Class>();
interfaces.add(Animal.class);
if (cage.animal instanceof Run) {
    interfaces.add(Run.class);
}
if (cage.animal instanceof Fly) {
    interfaces.add(Fly.class);
}

Proxy.getProxyClass(cl, interfaces.toArray(new Class[interfaces.size()]));