@Temporal(TemporalType.TIMESTAMP)
@Column(name = "CreatedOn", nullable = false)
public Date getCreatedOn() {
    return this.createdOn;
}

public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
}