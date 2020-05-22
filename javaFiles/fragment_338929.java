InputClass[] removeNulls(InputClass[] original) {
    List<InputClass> nonNulls = new ArrayList<InputClass>();
    for (InputClass i : original) {
        if (i != null) {
            nonNulls.add(i);
        }
    }

    return nonNulls.toArray(new InputClass[0]);
}