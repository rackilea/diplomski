public void hasDuplicates(List<Artifact> p_cars) {
    final List<String> usedNames = new ArrayList<String>();
    Iterator<Artifact> it = p_cars.iterator();
    while (it.hasNext()) {
        Artifact car = it.next();
        final String name = car.getObjectId();

        if (usedNames.contains(name)) {
            it.remove();

        } else {
            usedNames.add(name);
        }
    }

}