@Bindable
public String getInspectedDate() {
    return this.inspectedDate;
}

public void setInspectedDate(String inspectedDate) {
    this.inspectedDate = inspectedDate;
    notifyPropertyChanged(BR.inspectedDate);
}