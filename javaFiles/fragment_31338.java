strs.get(strs.indexOf(new Object() {
    @Override
    public boolean equals(Object obj) {
        return obj.toString().contains(s);
    }
}));