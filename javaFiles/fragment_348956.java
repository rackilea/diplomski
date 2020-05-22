Class<KnownSuper> superClass = KnownSuper.class; //class with callMethod()
for (Class<?> klass : f.keySet()) {
    if (superClass.isAssignableFrom(klass)) {
        f.getFavorite(klass.asSubClass(superClass)).callMethod()
    }
}