public List<Pair<Double, Double>> getTranslated() {
    List<Pair<Double, Double>> ret = new ArrayList<>();

    double[] list = getList(); // Calling our native method
    for(int i = 0; i < list.length; i += 2) {
        ret.add(new Pair<>(list[i], list[i + 1]));
    }

    return ret;
}