@PrePersist
public void defaultIsActive() {
    if(isActive == null) {
        isActive = Boolean.TRUE;
    }
}