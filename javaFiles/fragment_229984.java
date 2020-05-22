void addArray(double val1, double val2) {
    Exercise exercise = new Exercise(val1, val2);
    if (!arrays.containsKey(exercise)) {
        arrays.put(exercise, 1);
    } else {
        arrays.put(exercise, arrays.get(exercise) + 1);
    }
}