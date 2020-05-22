public void setDate(Date date, ChildDateUpdater childDateUpdater) {
    this.date = date;
    for (Child child : children) {
        childDateUpdater.updateChildDate(child);
    }
}