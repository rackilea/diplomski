public Collection<JAnnotationUse> annotations() {
    if(this.annotations == null) {
        this.annotations = new ArrayList();
    }

    return Collections.unmodifiableCollection(this.annotations);
}