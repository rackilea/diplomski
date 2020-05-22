ds.print(new Function<Integer,Boolean>() {
    @Override
    public Boolean apply(Integer index) {
        if (index % 2 == 0) return Boolean.TRUE;
        return Boolean.FALSE;
    }
});