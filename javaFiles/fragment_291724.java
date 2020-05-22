@JsonProperty("custom_name")
@Column(name = "fl_enabled")
private boolean isEnabled;

public boolean isEnabled() {
    return isEnabled;
}

public void setEnabled(boolean isEnabled) {
    this.isEnabled = isEnabled;
}