public enum ENUM1 {

    KEY_1(Arrays.asList(1, 2, 3)),
    KEY_2(Arrays.asList(4, 5, 6));

    ENUM1(List<Integer> ps) {
        params = Collections.unmodifiableList(ps);
    }

    private List<Integer> params;

    public int getP(int idx) {
        return params.get(idx);
    }

}