class FQP extends LinkedList<String> implements FilterQueryProvider {
    @Override
    public Cursor runQuery(CharSequence constraint) {
        if (constraint == null) {
            return null;
        }
        Log.d("TAG", "runQuery " + constraint);

        String lowerConstraint = constraint.toString().toLowerCase();
        String[] columns = {
                "_id", "name"
        };
        int id = 0;
        MatrixCursor c = new MatrixCursor(columns);
        for (String name : this) {
            String lowerName = name.toLowerCase();
            if (lowerName.indexOf(lowerConstraint) != -1) {
                c.newRow().add(id++).add(name);
            }
        }
        return c;
    }
};