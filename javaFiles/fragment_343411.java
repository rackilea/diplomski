@PostPersist
@PostLoad
public void initialiazeBId() {
    if (this.bId == null) {
        this.bId = aId;
    }
}