public boolean getEnabled() {
    return this.enabled;
}
public boolean getCalculatedEnabled() {
    return getCalculatedEnabled(this);
}

private boolean getCalculatedEnabled(CategoryEntity cat){
    if(cat != null && cat.getEnabled()){  //this will trigger the lazy initialization of the object
        if(cat.getParentCategory() == null) return true;
        return getCalculatedEnabled(cat.getParentCategory());
    }
    return false;
}