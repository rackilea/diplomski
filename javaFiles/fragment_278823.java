for (Class<?> cls : Parent.class.getDeclaredClasses()) {
    if (!Modifier.isStatic(cls.getModifiers())) {
        // This is an inner class. Do your thing here.
    } else {
        // This is a nested class. Not sure if you're interested in this.
    }
}