class Compound {
    String last;
    String compound;
    int lastSuffixCount;

    Compound() {
        this.last = "";
        this.compound = "";
        this.lastSuffixCount = 0;
    }

    public String getCompound() {
        return compound;
    }

    public void setCompound(String compound) {
        this.compound = compound;
    }

    public void add(String suffix, int times) {
        if (suffix.equals(this.last) && times > 0) 
        {
            this.compound = compound.replace(lastSuffixCount + "", "");
            this.lastSuffixCount = lastSuffixCount + times;
            this.compound += lastSuffixCount;
        } else if (times > 0) {
            this.compound += suffix + times;
        }
        this.lastSuffixCount = times;
        this.last = suffix;
    }
}