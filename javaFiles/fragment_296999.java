public boolean equals(Object c) {
    if(c !instanceof CustomClass) {
        return false;
    }
    // TODO change to your type and change the methods
    CustomClass that = (CustomClass)c;
    return this.id.equals(that.getId()) && this.id.equals(that.getId());
}