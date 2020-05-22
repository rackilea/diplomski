/**
 * Set default data while saving
 */
public void save() {
    this.createdOn = new Date();
    this.updatedOn = new Date();
    super.save();
}

/**
 * Set default data while updating
 */
public void update(Object o) {
    // here you don't want to change createdOn value anymore
    this.updatedOn = new Date(); 
    super.update(o);
}