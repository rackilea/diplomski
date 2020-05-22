static class ObjectSortComparator implements Comparator<ObjectSort> {
    @Override
    public int compare (ObjectSort f1, ObjectSort f2) {
        // Get the allocation priorities
        int priority1 = f1.getPriority ();
        int priority2 = f2.getPriority ();

        return priority1 == priority2 ? 0 : (priority1 > priority2 ? 1 : -1);
    }
}