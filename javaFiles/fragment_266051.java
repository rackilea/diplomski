protected <T extends OurSpecialClass> void addIfAbsentOrReplace(T toAdd, List<T> elementList) {
    OurSpecialClassReplaceOperator<T> op = new OurSpecialClassReplaceOperator<>(toAdd);
    synchronized (elementList) {
        elementList.replaceAll(op);
        if (!op.isReplaced()) {
            elementList.add(toAdd);
        }
    }
}

private class OurSpecialClassReplaceOperator<T extends OurSpecialClass> implements UnaryOperator<T> {

    private boolean replaced = false;

    private T toAdd;

    public OurSpecialClassReplaceOperator(T toAdd) {
        this.toAdd = toAdd;
    }

    @Override
    public T apply(T toAdd) {
        if (this.toAdd.getID().equals(toAdd.getID())) {
            replaced = true;
            return this.toAdd;
        }

        return toAdd;
    }

    public boolean isReplaced() {
        return replaced;
    }
}