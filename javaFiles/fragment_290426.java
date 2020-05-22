class ABC {
    private List<DEF> defList = Collections.emptyList();

    public List<DEF> getDefList() { 
        return defList;
    }

    public void setDefList(List<DEF> defList) {
        // defensively copy, then make immutable
        defList = new ArrayList<>(defList);
        this.defList = Collections.unmodifiableList(defList);
    }