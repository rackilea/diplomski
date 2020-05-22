public String getId() {
    if (this.id != null) {
        return this.id;
    } 
    this.id = populateId();
    return this.id;
}