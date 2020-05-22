static int dimension2(Object object) {

    int result = 0;
    if (object instanceof List<?>) {

        result++;
        List<?> list = (List<?>) object;
        for (Object element : list) {
            if (element != null) {
                result += dimension2(element);
                break;
            }
        }
    }

    return result;
}


static Object cast2(List<?> l) {

    int dim = dimension2(l);
    if (dim == 1) {
        return l.toArray(new String[0]);
    }

    int[] dims = new int[dimension2(l)];
    dims[0] = l.size();
    Object a = Array.newInstance(String.class, dims);
    for (int i = 0; i < l.size(); i++) {

        List<?> e = (List<?>) l.get(i);
        if (e == null) {
            Array.set(a, i, null);
        } else if (dimension2(e) > 1) {
            Array.set(a, i, cast2(e));
        } else {
            Array.set(a, i, e.toArray(new String[0]));
        }
    }
    return a;
}